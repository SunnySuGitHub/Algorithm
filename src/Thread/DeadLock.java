package Thread;

/**
 * Description:写一个死锁程序
 * Created by Administrator on 2019/2/24
 */
public class DeadLock {
    public static void main(String[] args) {
        MakeUp m1 = new MakeUp("zhangsan", 0);
        MakeUp m2 = new MakeUp("lisi", 1);
        m1.start();
        m2.start();
    }
}

class LipStick{}

class Mirror{}

class MakeUp extends Thread{
    public static LipStick lipStick = new LipStick();
    public static Mirror mirror = new Mirror();
    String name;
    int choice;
    public MakeUp(String name, int choice){
        this.name = name;
        this.choice = choice;
    }

    @Override
    public void run(){
        this.makeUp();
    }
    public void makeUp(){
        if(choice == 0){
            synchronized (lipStick){
                System.out.println(Thread.currentThread().getName() + "持有lipstick");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (mirror){
                    System.out.println(Thread.currentThread().getName() + "持有mirror");
                }
            }
        } else {
            synchronized (mirror){
                System.out.println(Thread.currentThread().getName() + "持有mirror");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lipStick){
                    System.out.println(Thread.currentThread().getName() + "持有lipstick");
                }
            }
        }
    }




}
