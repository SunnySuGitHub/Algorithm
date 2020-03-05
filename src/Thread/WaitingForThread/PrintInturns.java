package Thread.WaitingForThread;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:A、B、C三个线程实现轮流打印
 * Created by Administrator on 2019/6/10
 */
public class PrintInturns {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition A_run = lock.newCondition();
        Condition B_run = lock.newCondition();
        Condition C_run = lock.newCondition();

        final StringBuilder sb = new StringBuilder("Hello");

        Thread A = new Thread(()->{
            while(true){
                lock.lock();
                sb.append("_A");
                B_run.signalAll();
                try {
                    A_run.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A");
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    lock.lock();
                    sb.append("_B");
                    C_run.signalAll();
                    try {
                        B_run.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "B");
        Thread C = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    lock.lock();
                    sb.append("_C");
                    A_run.signalAll();
                    try {
                        C_run.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "C");
        A.start();
        B.start();
        C.start();
        try {
            C.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(sb.toString());
    }
}

