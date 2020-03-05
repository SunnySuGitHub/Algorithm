package GOF.Proxy.StaticProxy;

/**
 * Description:被代理类
 * Created by Administrator on 2019/4/21
 */
public class Business implements BusinessInterface {

    @Override
    public void execute() {
        System.out.println("真正对象执行业务逻辑...");
    }
}
