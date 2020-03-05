package GOF.Proxy.StaticProxy;

/**
 * Description:测试静态代理
 * Created by Administrator on 2019/4/21
 */
public class test {
    public static void main(String[] args) {
        BusinessInterface proxy = new BusinessProxy(new Business());
        proxy.execute();
    }
}
