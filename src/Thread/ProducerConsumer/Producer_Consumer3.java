package Thread.ProducerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Description:Algorithm
 * Created by Administrator on 2019/5/28
 * BlockingQueue接口实现生产者消费者
 */
public class Producer_Consumer3 {
    private static BlockingQueue queue = new ArrayBlockingQueue(100);

    public void produce(){
        while(true){
            try {
                queue.put(new Object());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("生产者" + Thread.currentThread().getName() + "生产第 " + queue.size() + " 个");
        }
    }

    public void consume(){
        while(true){
            try {
                queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("消费者" + Thread.currentThread().getName() + "消费，剩余 " + queue.size() + " 个");
        }
    }

    public static void main(String[] args) {
        Producer_Consumer3 producer_consumer3 = new Producer_Consumer3();
        new Thread(()->
        {
            producer_consumer3.produce();
        }, "producer1").start();
        new Thread(()->
        {
            producer_consumer3.consume();
        }, "comsumer").start();
    }
}
