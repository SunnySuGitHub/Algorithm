package Thread.ThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Description:定时执行线程池
 * 定时场景任务使用
 * Created by Administrator on 2019/2/26
 */
public class ScheduledThreadPool {

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(4);


        service.scheduleAtFixedRate(()->{
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }, 0, 500, TimeUnit.MILLISECONDS);


    }
}
