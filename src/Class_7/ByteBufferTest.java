package Class_7;

import java.nio.ByteBuffer;

/**
 * Description:Algorithm
 * Created by Administrator on 2019/5/10
 */
public class ByteBufferTest {
    public static void main(String[] args) {
        ByteBuffer buffer =ByteBuffer.allocate(1024);
        buffer.put("hello".getBytes());
        System.out.println(buffer);
        buffer.flip();
        ByteBuffer buffer1 = buffer.slice();
        System.out.println(buffer1);
    }
}
