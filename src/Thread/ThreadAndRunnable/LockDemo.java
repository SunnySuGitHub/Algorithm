package Thread.ThreadAndRunnable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:Algorithm
 * Created by Administrator on 2019/5/19
 */
public class LockDemo{
    private ReentrantLock lock = new ReentrantLock(true);
    private ReentrantLock fun = new ReentrantLock(true);
    private int cnt = 0;
    //lock可以理解为一种资源，只有拿到了这个资源才可以进行下面的代码块
    //每new出来一个lock，针对这个lock有一个他自己的等待队列
    //只有调用了这个lock的lock方法和unlock方法才可以进行对这个lock逻辑的同步
    //因为是面对对象编程，如果不是操作同一个对象，也就不存在同步问题了
    //正是因为针对一个对象或者变量进行操作才需要进行同步
    //在这个对象里new出来一个lock，用这个lock针对一系列的方法进行lock和unlock方法来获取操作权，实现同步
    //lock继承自AQS，自身维护了一个等待线程队列，获取该锁失败的会被添加进队列中

    private void show() {
        while(true){
            try{
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " get the lock");
                System.out.println(Thread.currentThread().getName() + " " + cnt++);
                Thread.sleep(100);
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    private void fun(){
        while(true){
            try{
                fun.lock();
                System.out.println(Thread.currentThread().getName() + " is later");
                System.out.println(Thread.currentThread().getName() + " " + cnt++);
                Thread.sleep(1000);
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                fun.unlock();
            }
        }
    }

    public static void main(String[] args) {
        LockDemo demo = new LockDemo();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                demo.show();
            }
        }, "a");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                demo.show();
            }
        }, "b");
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                demo.show();
            }
        }, "c");
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                demo.show();
            }
        }, "d");
        Thread t5 = new Thread(new Runnable() {
            @Override
            public void run() {
                demo.show();
            }
        }, "e");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
