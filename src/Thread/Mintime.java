package Thread;

/**
 * Description:Algorithm
 * Created by Administrator on 2019/2/24
 */
public class Mintime {
    public int count = 10;
    public synchronized void doWork(){
        System.out.println(Thread.currentThread().getName() + "执行中" + count--);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "执行完毕" + count--);
    }

    public synchronized void doWork2(){
        System.out.println(Thread.currentThread().getName() + "执行中" + count--);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "执行完毕" + count--);
    }
}

class Main{
    public static void main(String[] args) {
        Mintime mintime = new Mintime();
        new Thread(new Runnable() {
            @Override
            public void run() {
                mintime.doWork();
            }
        }).start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                mintime.doWork2();
            }
        }).start();
    }
}
