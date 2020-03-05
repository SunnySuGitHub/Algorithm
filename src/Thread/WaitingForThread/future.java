package Thread.WaitingForThread;

import java.util.concurrent.*;

/**
 * Description:future机制实现线程等待
 * Created by Administrator on 2019/6/6
 */
public class future {
    public static ExecutorService threadPoll = Executors.newFixedThreadPool(5);
    public static void main(String[] args) {
        Call call = new Call();
        Future<String> futureTask = threadPoll.submit(call);
        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.get();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Main is done");
    }
}

class Call implements Callable{

    @Override
    public String call() throws Exception {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName() + " is done";
    }
}
