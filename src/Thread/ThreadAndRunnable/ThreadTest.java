package Thread.ThreadAndRunnable;

/**
 * Description:Algorithm
 * Created by Administrator on 2019/5/16
 */
public class ThreadTest {
    public static void main(String[] args) {
        Runna runna = new Runna();
        new Thread(runna).start();
        new Thread(runna).start();
        new Thread(runna).start();
        new Thread();
    }
}

class thread extends Thread{
    private int cnt = 10;

    @Override
    public void run() {
        if(cnt > 0){
            System.out.println(Thread.currentThread().getName() + ": " + cnt--);
        }
    }
}

class Runna implements Runnable{

    private int cnt = 10;

    @Override
    public synchronized void run() {
        if(cnt > 0){
            System.out.println(Thread.currentThread().getName() + ": " + cnt--);
        }
    }
}
