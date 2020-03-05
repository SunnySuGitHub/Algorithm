package Thread.TicketsSeller;

import java.util.Vector;

/**
 * Description:Vector里面remove方法是原子性的，但是判断和操作分离了
 * Created by Administrator on 2019/2/26
 */
public class TicketsSeller2 {
    static Vector<String> tickets = new Vector<>();

    static{
        for(int i = 0 ; i < 10000; i++){
            tickets.add("票编号：" + i);
        }
    }

    public static void main(String[] args) {
        for(int i = 0 ; i < 100; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(tickets.size() > 0){//此处判断和操作分离，即使Vector是原子性操作
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("销售" + tickets.remove(0));
                    }
                }
            }).start();
        }
    }
}
