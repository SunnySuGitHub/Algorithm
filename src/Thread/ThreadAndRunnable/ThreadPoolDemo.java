package Thread.ThreadAndRunnable;

import java.util.concurrent.*;

/**
 * Description:Algorithm
 * Created by Administrator on 2019/5/17
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
//        for (int i = 0; i < 10; i++){
//            threadPool.submit(new MyCallable());
//        }
        Future<String> future = threadPool.submit(new MyCallable());
        try{
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally{
            threadPool.shutdown();
        }

    }
}
