package GOF.Singleton;

/**
 * Description:静态内部类
 * Created by Administrator on 2019/3/23
 */
public class staticInnerClass {

    public staticInnerClass(){

    }

    private static class InnerClass{
        public static final staticInnerClass instance = new staticInnerClass();
    }

    public static staticInnerClass getInstance(){
        return InnerClass.instance;
    }
}
