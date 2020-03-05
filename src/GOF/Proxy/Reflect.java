package GOF.Proxy;

import java.lang.reflect.Method;

/**
 * Description:反射实现
 *
 * 根据Class名称获取Class文件
 * 根据Class获得特定方法method
 * 根据Class文件newInstance出来
 * 调用method的invoke方法
 *
 * Created by 苏新宇 on 2019/4/21
 */
public class Reflect {
    public static void main(String[] args) throws Exception {
        Class c = Class.forName("GOF.Proxy.CustomerService");
        Method method = c.getDeclaredMethod("login", String.class, String.class);
        Method method2 = c.getDeclaredMethod("logout");
        CustomerService customerService = (CustomerService) c.newInstance();
        Object res = method.invoke(customerService, "admin", "123");
        System.out.println(res);
        Object res2 = method2.invoke(customerService);
        System.out.println(res2);
    }
}

class CustomerService{
    public boolean login(String name, String pwd){
        if(name.equals("admin") && pwd.equals("123")){
            return true;
        }
        return false;
    }

    public void logout(){
        System.out.println("安全退出");
    }
}


