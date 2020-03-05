package GOF.Proxy.JDKDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Description:Algorithm
 * Created by Administrator on 2019/4/21
 */
public class JdkDynamicProxy implements InvocationHandler {

    private Object subject;

    public JdkDynamicProxy(Object subject){
        this.subject = subject;
    }
//
//    public static Subjectt getInstance(Object subject){
//        return (Subjectt) GOF.Proxy.newProxyInstance(JdkDynamicProxy.class.getClassLoader(),
//                subject.getClass().getInterfaces(), new JdkDynamicProxy(subject));
//    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用真正方法前，比如做日志处理");
        method.invoke(subject,args);
        System.out.println("方法调用完成后");
        return null;
    }
}
