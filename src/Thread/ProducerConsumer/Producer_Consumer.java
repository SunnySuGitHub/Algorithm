package Thread.ProducerConsumer;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 * Created by Administrator on 2019/2/25
 * ReentrantLock和Condition结合使用实现生产者消费者模式
 */
public class Producer_Consumer<T> {
    final private LinkedList<T> lists = new LinkedList<>();
    final private int MAX = 10;

    Lock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();

    public void put(T t) {
        try {
            lock.lock();
            while (lists.size() == MAX) {
                producer.await();//使当前线程wait在producer上
            }

            lists.add(t);
            consumer.signalAll();//唤醒等待在consumer上的线程
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public T get() {
        T t = null;
        try {
            lock.lock();
            while (lists.size() == 0) {
                consumer.await();//使当前线程等待在consumer上
            }
            t = lists.removeFirst();
            producer.signalAll();//唤醒等待在producer上的线程
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        Producer_Consumer producer_consumer = new Producer_Consumer();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        System.out.println(Thread.currentThread().getName() + " get " + producer_consumer.get());
                    }
                }
            }).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int j = 0; j < 2; j++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 25; i++) {
                        producer_consumer.put(Thread.currentThread().getName() + " put " + i);
                    }
                }
            }).start();
        }
    }
}
