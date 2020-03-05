package Thread.TicketsSeller;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Description:使用并发容器(ConcurrentLinkedQueue)实现同步
 * Created by Administrator on 2019/2/26
 */
public class TicketsSeller4 {
    static Queue<String> tickets = new ConcurrentLinkedQueue<String>();

    static{
        for(int i = 0 ; i < 10000; i++){
            tickets.offer("票编号：" + i);
        }
    }

    public static void main(String[] args) {
        for(int i = 0 ; i < 10; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        String s = tickets.poll();
                        if(s == null){
                            break;
                        }else{
                            System.out.println("销售" + s);
                        }
                    }
                }
            }).start();
        }
    }
}
