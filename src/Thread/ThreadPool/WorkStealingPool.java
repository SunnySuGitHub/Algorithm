package Thread.ThreadPool;

/**
 * Description:工作窃取线程池
 * 每个线程都维护着自己的一个任务队列
 * 当某一线程自己队列的任务执行完之后会去其他线程的队列steal一个任务去执行
 * 底层实现是ForkJoinPool
 * Created by Administrator on 2019/2/26
 */
public class WorkStealingPool {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

}
