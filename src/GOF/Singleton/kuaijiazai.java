package GOF.Singleton;

/**
 * Description:饿汉式
 * Created by Administrator on 2019/3/23
 */
public class kuaijiazai {

    public kuaijiazai(){

    }

    private static kuaijiazai instance = new kuaijiazai();

    public kuaijiazai getInstance(){
        return instance;
    }
}
