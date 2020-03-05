package Thread.ThreadAndRunnable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Description:Algorithm
 * Created by Administrator on 2019/5/16
 */
public class FuturetaskDeme {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask =  new FutureTask<>(new MyCallable());
        new Thread(futureTask).start();
        if(!futureTask.isDone()){
            System.out.println("working...");
        }
        System.out.println(futureTask.get());
    }
}

