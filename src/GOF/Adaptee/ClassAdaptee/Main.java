package GOF.Adaptee.ClassAdaptee;

/**
 * Description:Algorithm
 * Created by Administrator on 2020/2/29
 */
public class Main {
    public static void main(String[] args) {
        Target target = new Adaptor();
        target.request();
        /**
         * 适配器类Adaptor通过目标接口类方法代为调用被适配器类方法
         */
    }
}

