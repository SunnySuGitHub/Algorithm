package Thread.ProducerConsumer;

import java.util.HashMap;
import java.util.LinkedList;


/**
 * Description:Algorithm
 * Created by Administrator on 2019/5/28
 * 结合wait和notify实现生产者消费者模式
 */
public class Producer_Consumer2 {

    public static final LinkedList list = new LinkedList();
    public static final int MAX = 100;

    public void produce() throws InterruptedException {
        while (true) {
            synchronized (list) {
                /**
                 * 这里wait和while一定要结合起来使用，否则会出现线程安全问题
                 * 假设有AB两个生产者，A生产者获取到锁，将队列生产满，wait
                 *
                 * B生产者从wait代码处被唤醒，如果是if，接下来的代码会继续生产，出现超卖现象
                 * 生产者Producer1现生产第 96 件商品
                 * 生产者Producer1现生产第 97 件商品
                 * 生产者Producer1现生产第 98 件商品
                 * 生产者Producer1现生产第 99 件商品
                 * 生产者Producer1现生产第 100 件商品
                 * 生产者Producer2现生产第 101 件商品  Producer2从wait处被唤醒，没有再次判断，去生产，导致之后的一系列错误，线程安全问题
                 * 生产者Producer2现生产第 102 件商品
                 * 生产者Producer2现生产第 103 件商品
                 * 生产者Producer2现生产第 104 件商品
                 *
                 * 如果是while，B生产者从wait处被唤醒后，还要循环一次检查队列是否为满，满的话继续wait，不满才去生产
                 */
                while (list.size() == MAX) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.add(new Object());
                System.out.println("生产者" + Thread.currentThread().getName() + "现生产第 " + list.size() + " 件商品");
                list.notify();
            }
        }

    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (list) {
                while (list.size() == 0) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.remove();
                System.out.println("消费者消费,剩余 " + list.size() + " 件商品");
                list.notify();
            }
        }
    }

    public static void main(String[] args) {
        Producer_Consumer2 producer_consumer2 = new Producer_Consumer2();
        for(int i = 0; i < 2; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        producer_consumer2.produce();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "Producer1").start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        producer_consumer2.produce();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "Producer2").start();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producer_consumer2.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Consumer").start();

    }
}

