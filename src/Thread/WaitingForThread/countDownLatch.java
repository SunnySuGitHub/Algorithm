package Thread.WaitingForThread;

import java.util.concurrent.CountDownLatch;

/**
 * Description:CountDownLatch实现线程等待
 * Created by Administrator on 2019/6/6
 */
public class countDownLatch {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(1);
        Demo demo = new Demo(latch);
        Thread t1 = new Thread(demo);
        t1.start();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main is done");
    }
}

class Demo implements Runnable{

    CountDownLatch latch;

    public Demo(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " is done");
        latch.countDown();
    }
}
