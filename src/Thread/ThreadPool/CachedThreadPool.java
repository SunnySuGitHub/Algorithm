package Thread.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Description:CachedThreadPool
 * 一开始一个线程都没有，来一个任务就启动一个线程，如果有空闲的线程，那么新任务就交给这个线程执行
 * 如果没有空闲线程，就new一个线程。每个线程默认生存时间为60s
 * Created by Administrator on 2019/2/26
 */
public class  CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        System.out.println(service);
        for(int i = 0; i < 2; i++){
            service.execute(()->{
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }

        System.out.println(service);

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(service);

    }


}
