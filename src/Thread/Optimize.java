package Thread;

/**
 * Description:Algorithm
 * Created by Administrator on 2019/2/23
 */
public class Optimize {
    public void doLongTimeTask(){
        try{
            System.out.println("当前线程开始" + Thread.currentThread().getName() + ",正在执行一个时间比较长的业务");
            Thread.sleep(2000);
            synchronized(Optimize.class){
                System.out.println("当前线程" + Thread.currentThread().getName() + "正在执行任务");
                Thread.sleep(5000);
                System.out.println("当前线程" + Thread.currentThread().getName() + "执行结束");
            }
            System.out.println(Thread.currentThread().getName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class main{
    public static void main(String[] args) {
        Optimize optimize = new Optimize();
        Optimize optimize2 = new Optimize();
        Optimize optimize3 = new Optimize();
        Optimize optimize4 = new Optimize();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                optimize.doLongTimeTask();
            }
        });
        Thread t2 = new Thread(){
            @Override
            public void run(){
                optimize.doLongTimeTask();
            }
        };
        Thread t3 = new Thread(){
            @Override
            public void run(){
                optimize.doLongTimeTask();
            }
        };
        Thread t4 = new Thread(){
            @Override
            public void run(){
                optimize.doLongTimeTask();
            }
        };
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
