package Thread.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * ExecutorService与ThreadPool搭配使用
 * Created by Administrator on 2019/2/26
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        //new一个拥有5个线程的线程池
        /**
         * 线程池里面有很多线程，等待分配任务。没人做的任务被分配在一个任务列表里，维护着此任务列表，并且还维护着一个已完成任务列表
         *
         * Executors是一个工厂，提供很多方法和接口
         */
        ExecutorService service = Executors.newFixedThreadPool(5);

        //开启六个任务
        for(int i = 0 ; i < 6; i++){

            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        TimeUnit.MILLISECONDS.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        System.out.println(service);

        //shutdown要等到所有的任务都执行完再shutdown
        service.shutdown();
        System.out.println(service.isTerminated());
        System.out.println(service.isShutdown());
        System.out.println(service);

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(service.isTerminated());
        System.out.println(service.isShutdown());
        System.out.println(service);

        /**
         * 输出：
         * 一共五个线程，六个任务，每个线程执行一个任务，第六个任务没人执行，被丢到任务队列里面，即queued tasks
         * java.util.concurrent.ThreadPoolExecutor@135fbaa4[Running, pool size = 5, active threads = 5, queued tasks = 1, completed tasks = 0]
         * false
         * true
         * java.util.concurrent.ThreadPoolExecutor@135fbaa4[Shutting down, pool size = 5, active threads = 5, queued tasks = 1, completed tasks = 0]
         * pool-1-thread-3
         * pool-1-thread-5
         * pool-1-thread-4
         * pool-1-thread-2
         * pool-1-thread-1
         * pool-1-thread-3
         * true
         * true
         * java.util.concurrent.ThreadPoolExecutor@135fbaa4[Terminated, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 6]
         */
    }
}
