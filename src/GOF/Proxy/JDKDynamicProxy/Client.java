package GOF.Proxy.JDKDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Description:JDK动态代理
 * 在java的动态代理机制中，有两个重要的类或接口，
 * 一个是 InvocationHandler(Interface)、另一个则是 GOF.Proxy(Class)，这一个类和接口是实现我们动态代理所必须用到的
 *
 * 首先new出来真实的对象，即被代理对象
 * new出来代理对象
 * 利用Proxy类的newProxyInstance方法获取动态代理对象
 * 调用方法
 * Created by Administrator on 2019/4/21
 */
public class Client {
    public static void main(String[] args) {
        //首先new一个被代理对象出来
        Subjectt realSubjectt = new RealSubjectt();
        //将被代理对象作为参数传入到代理对象中
        InvocationHandler jdkDynamicProxy = new JdkDynamicProxy(realSubjectt);

        //用被代理类实现的接口来接收 根据代理类的类加载器、被代理类实现的接口、代理对象生成的动态代理对象
        //GOF.Proxy.newProxyInstance生成的类已经是继承了Proxy类，再实现这个接口，所以JDK动态代理不像Cglib是继承类来实现的
        Subjectt subjectt1 = (Subjectt) Proxy.newProxyInstance(jdkDynamicProxy.getClass().getClassLoader(),
                realSubjectt.getClass().getInterfaces(), jdkDynamicProxy);
        System.out.println(subjectt1.getClass().getGenericSuperclass());
//        Subjectt subjectt1 = JdkDynamicProxy.getInstance(realSubjectt);
        System.out.println(subjectt1.getClass().getName());
        //利用动态代理对象执行方法
        subjectt1.rent();
        subjectt1.hello("suxinyu");
    }
}
