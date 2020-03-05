package GOF.Singleton;

/**
 * Description:懒汉式
 * Created by Administrator on 2019/3/23
 */
public class lanjiazai {

    public lanjiazai(){

    }

    private static lanjiazai instance = null;

    public static lanjiazai getInstance(){
        if (instance == null){
            instance = new lanjiazai();
        }
        return instance;

    }
}
