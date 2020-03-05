package Thread.TicketsSeller;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Description:Algorithm
 * Created by Administrator on 2019/3/9
 */
public class Blocking {

    static BlockingQueue<String> strs = new LinkedBlockingQueue<>();//自动实现阻塞，生产者消费者模式。无界队列
    //永远不会充满

    static int i=  1;

    public static void main(String[] args) {
        new Thread(()->{
            while(true){
                try {
                    strs.put("a" + i++);
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "p1").start();

        for(int j = 0; j < 5; j++){
            new Thread(()->{
                for(;;){
                    try {
                        System.out.println(Thread.currentThread().getName() + "take -" + strs.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "c" + j).start();
        }
    }
}
