package Thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:reentrantlock学习
 * 需要注意的是，必须必须必须要手动释放锁
 * 使用synchronized锁定的话如果遇到异常，jvm会自动释放锁，但是lock必须手动释放锁，因此经常在finally中进行锁的释放
 * Created by Administrator on 2019/2/25
 */
public class reentranlock {
    //ReentrantLock是Lock接口的实现
    Lock lock = new ReentrantLock();

    synchronized void m1() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    synchronized void m2() {
        lock.lock();
        System.out.println("m2......");
        lock.unlock();
    }

    public static void main(String[] args) {
        reentranlock reentranlock = new reentranlock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                reentranlock.m1();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                reentranlock.m2();
            }
        }).start();
    }
}

