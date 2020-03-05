package Thread.Volatile;

/**
 * Description:Algorithm
 * Created by Administrator on 2019/2/24
 */
public class Volatile {
    /*volatile*/ boolean running = true;
    void m(){
        System.out.println("m start!");
        while(running){

        }
        System.out.println("m end!");
    }

    public static void main(String[] args) {
        Volatile v = new Volatile();
        new Thread(new Runnable(){
            @Override
            public void run(){
                v.m();
            }
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        v.running = false;
    }
}
