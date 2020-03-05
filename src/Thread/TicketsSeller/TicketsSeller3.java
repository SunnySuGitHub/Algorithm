package Thread.TicketsSeller;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:Algorithm
 * Created by Administrator on 2019/2/26
 */
public class TicketsSeller3 {
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
                    while(true){
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (tickets){
                            if(tickets.size() > 0){
                                System.out.println("销售了" + tickets.remove(0));
                            }
                        }
                    }
                }
            }).start();
        }
    }
}
