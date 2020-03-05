package GOF.Proxy.JDKDynamicProxy;

/**
 * Description:Algorithm
 * Created by Administrator on 2019/4/21
 */
public class RealSubjectt implements Subjectt {
    @Override
    public void rent() {
        System.out.println("I want to rent my house");
    }

    @Override
    public void hello(String name) {
        System.out.println("Hello" + name);
    }
}
