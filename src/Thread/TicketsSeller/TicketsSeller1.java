package Thread.TicketsSeller;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:没有同步，出现越界情况并且List的remove方法不是原子性操作
 * Created by Administrator on 2019/2/26
 */
public class TicketsSeller1 {
    static List<String> tickets = new ArrayList<>();

    static{
        for(int i = 0 ; i < 10000; i++){
            tickets.add("票编号： " + i);
        }
    }

    public static void main(String[] args) {
        for(int i = 0 ; i < 10; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(tickets.size() > 0){
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("销售了" + tickets.remove(0));
                    }
                }
            }).start();
        }
    }
}
