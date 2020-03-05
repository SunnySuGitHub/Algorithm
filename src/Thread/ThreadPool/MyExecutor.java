package Thread.ThreadPool;

import java.util.concurrent.Executor;

/**
 * Description:Executor接口
 * 执行器
 * Created by Administrator on 2019/2/26
 */
public class MyExecutor implements Executor {

    public static void main(String[] args) {
        new MyExecutor().execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello executor!");
            }
        });
    }


    @Override
    public void execute(Runnable command){
        command.run();
    }

}
