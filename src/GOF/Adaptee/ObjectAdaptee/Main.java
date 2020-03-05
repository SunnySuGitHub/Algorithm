package GOF.Adaptee.ObjectAdaptee;

/**
 * Description:Algorithm
 * Created by Administrator on 2020/2/29
 */
public class Main {
    public static void main(String[] args) {
        Target target = new Adaptor(new Adaptee());
        target.request();
        //通过成员变量组合关系实现
    }
}

