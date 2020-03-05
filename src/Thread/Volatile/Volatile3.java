package Thread.Volatile;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:Algorithm
 * Created by Administrator on 2019/2/25
 */
public class Volatile3 {
    volatile int count = 0;
    void m(){
        for(int i = 0; i < 10000; i++){
            count++;
        }
    }

    public static void main(String[] args) {
        Volatile3 v = new Volatile3();
        List<Thread> threads = new ArrayList<Thread>();
        for(int j = 0; j < 10; j++){
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    v.m();
                }
            }));
        }
        for(Thread t : threads){
            t.start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(v.count);
    }
}
