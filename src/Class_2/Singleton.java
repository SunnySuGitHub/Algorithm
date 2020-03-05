package Class_2;

/**
 * Description:Algorithm
 * Created by Administrator on 2019/3/23
 */
public class Singleton {

    private Singleton(){

    }

    public static class Instance{
        public static final Singleton instance = new Singleton();
    }

    public static Singleton getInstance(){
        return Instance.instance;
    }

}
