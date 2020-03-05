package Thread.WaitingForThread;

/**
 * Description:join方法实现线程等待
 * Created by Administrator on 2019/6/6
 */
public class join {
    public static void main(String[] args) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " is done");
            }
        }, "subThread");
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main is done");
    }
}
