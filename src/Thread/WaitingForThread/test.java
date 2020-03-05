package Thread.WaitingForThread;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description:Algorithm
 * Created by Administrator on 2019/8/29
 */
public class test {
    public static void main(String[] args) {
        System.out.println(porcess());
        ThreadLocal t = new ThreadLocal();
        t.get();
    }

    private static int porcess(){
        int i = 0;
        try{
            i = 1;
            return i;
        }finally{
            return i;
        }
    }
}
