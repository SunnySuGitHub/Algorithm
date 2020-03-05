package GOF.Factory.FactoryMethod;


/**
 * Description:Algorithm
 * Created by Administrator on 2020/2/29
 */
public class Main {
    public static void main(String[] args) {
        PhoneFactory factory = new HuaweiFactory();
        factory.porducePhone().dia();
    }
}

