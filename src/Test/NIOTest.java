package Test;


import org.junit.Test;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.*;
/**
 * Description:Algorithm
 * Created by Administrator on 2019/5/11
 */
public class NIOTest {
    private static final int TIMEOUT = 6000;
    private static final int BUFFSIZE = 1024;
    @Test
    public void client() throws IOException{
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",9797));//获取通道
        socketChannel.configureBlocking(false);//非阻塞

        ByteBuffer writeBuf = ByteBuffer.allocate(1024);
        ByteBuffer readBuf = ByteBuffer.allocate(1024);
        Random r = new Random();
        int count = 0;
        try{
            while(true) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                writeBuf.put((new Date().toString() + "\n" +"某个随机整数:"+ r.nextInt(10)).getBytes());
                writeBuf.flip();
                socketChannel.write(writeBuf);
                writeBuf.clear();
                int readBytes = socketChannel.read(readBuf);
                if(readBytes == -1) socketChannel.close();
                else if (readBytes > 0){
                    readBuf.flip();
                    System.out.println("客户端收到回显数据"+ new String(readBuf.array(),0,readBytes));
                    readBuf.clear();
                }
                //if(count == 20)break;
            }
        }catch (Exception e){
            socketChannel.close();
        }
        socketChannel.close();
    }

    /**
     * 服务端Demo，这里模拟这样一个条件：
     * 如果客户端发过来的字符串尾数是"7"，服务端需要回写。
     * @throws IOException
     */
    @Test
    public void server() throws IOException{
        //配置通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(9797));

        Selector selector = Selector.open(); //获取选择器
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);//为监听通道注册accept事件

        while(true) {//持续性监听
            if (selector.select(TIMEOUT) == 0) {
                System.out.println("（一小段时间内未有就绪事件）...");
                continue;
            }
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey key = it.next();
                //判断就绪的事件
                if(!key.isValid()){it.remove();continue;}//如果已经被取消的key，可以去除
                if (key.isAcceptable()) {
                    //多了个通道，进行非阻塞配置，进行读就绪注册
                    SocketChannel sc = serverSocketChannel.accept();
                    sc.configureBlocking(false);
                    sc.register(selector, SelectionKey.OP_WRITE,ByteBuffer.allocate(BUFFSIZE));//也可在这里为channel直接分配缓冲区大小，之后key通过key.attachment()作为缓冲区，attachment是一个volatile变量
                } else if (key.isReadable()) {
                    //获得读就绪状态的通道
                    SocketChannel sc = (SocketChannel) key.channel();
                    //读取数据(通道的缓冲区往往作为key的附属物)
                    ByteBuffer buf = (ByteBuffer)key.attachment();
                    try {
                        int len = sc.read(buf);//将收到的值写到buffer
                        String tmps = "";
                        if(len == -1) sc.close();//另一端已关闭
                        else if(len > 0) {
                            buf.flip();
                            System.out.println(tmps = new String(buf.array(), 0, len));
                            buf.rewind();
                            if(tmps.endsWith("7")){
                                System.out.println("出现幸运数字！");
//                                key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                                key.interestOps( SelectionKey.OP_WRITE);
                            }
                        }
                    } catch (IOException e) {//若读过程中对方断开连接，则将抛异常
                        //取消key并关闭通道
                        key.cancel();
                        sc.close();
                    }
                }
                //满足可写要求
                if(key.isValid() && key.isWritable()){
                    //获得读就绪状态的通道
                    SocketChannel sc = (SocketChannel) key.channel();
                    //读取数据
                    ByteBuffer buf = (ByteBuffer) key.attachment();
                    //ByteBuffer buf = ByteBuffer.allocate(BUFFSIZE);
                    //buf.put(new String("收到了数字7").getBytes());
                    //System.out.println("可写的key，当前buf状态"+"\nposition"+buf.position()+"\nlimit"+buf.limit() + "\ncapacity"+buf.capacity());
                    // buf.flip();因为之前已经flip过，所以在此flip会将limit也归零
                    //System.out.println("flip之后的buf状态"+"\nposition"+buf.position()+"\nlimit"+buf.limit() + "\ncapacity"+buf.capacity());

                    sc.write(buf);//之前打印用到了flip(),并且rewind过，故此处直接回写即可，也可从position == 0（limit > 0）判断
                    if(!buf.hasRemaining()) key.interestOps(SelectionKey.OP_READ);
                    buf.compact();//Make room for more data to be read in
                }
                //完成后去记得取消选择键
                it.remove();
            }
        }
    }
}
