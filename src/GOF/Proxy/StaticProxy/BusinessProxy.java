package GOF.Proxy.StaticProxy;

/**
 * Description:代理类
 * Created by Administrator on 2019/4/21
 */
public class BusinessProxy implements BusinessInterface{

    private Business business;

    public BusinessProxy(Business business){
        this.business = business;
    }

    @Override
    public void execute() {
        System.out.println("静态代理前置增强");
        business.execute();
        System.out.println("静态代理后置增强");
    }
}
