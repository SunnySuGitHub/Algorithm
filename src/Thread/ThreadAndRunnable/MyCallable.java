package Thread.ThreadAndRunnable;

import java.util.concurrent.Callable;

/**
 * Description:Algorithm
 * Created by Administrator on 2019/5/16
 */
public class MyCallable implements Callable {
    @Override
    public String call() throws Exception {
        String value = "test";
        System.out.println("Ready for work");
        Thread.currentThread().sleep(5000);
        System.out.println("task done");
        return value;
    }
}
