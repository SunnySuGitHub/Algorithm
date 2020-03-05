package Thread.Volatile;

/**
 * Description:volatile并不能保证多个线程共同修改某共同变量所带来的不一致问题，也就是说volatile不能替代synchronized
 * Created by Administrator on 2019/2/25
 */
public class Volatile2 {
    public static void main(String[] args) {
        Account account = new Account(5000, "aaa");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    account.draw(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    account.draw(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

class Account {
    volatile int balance;
    String name;

    public Account(int balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    public void draw(int money) throws InterruptedException {
        if (balance > 0) {
            Thread.sleep(100);
            balance -= money;
            System.out.println(Thread.currentThread().getName() + "取走了" + money);
            System.out.println("剩余：" + balance);
        }
    }
}
