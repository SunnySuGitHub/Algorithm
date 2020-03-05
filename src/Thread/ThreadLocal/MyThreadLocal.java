package Thread.ThreadLocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Description:Algorithm
 * Created by Administrator on 2019/8/4
 */
public class MyThreadLocal {

    private static ThreadLocal<String> strs = new ThreadLocal(){
        public String initialValue(){
            return "locals"+Thread.currentThread().getName();
        }
    };

    private static ThreadLocal<Integer> ints = new ThreadLocal(){
        public Integer initialValue(){
            return 0;
        }
    };


    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(5);
        while(true){
            service.submit(new Runnable() {
                @Override
                public void run() {
                    int i = ints.get();
                    System.out.println("str:"+strs.get());
                    System.out.println("int-"+Thread.currentThread().getName()+":"+i);
                    if(i == 5){
                        strs.set(strs.get() + "done");
                    }
                    ints.set(++i);
                }
            });
            Thread.sleep(10);
        }
    }

}

