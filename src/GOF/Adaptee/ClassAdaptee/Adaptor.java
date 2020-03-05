package GOF.Adaptee.ClassAdaptee;

/**
 * Description:Algorithm
 * Created by Administrator on 2020/3/1
 */
class Adaptor extends Adaptee implements Target{
    @Override
    public void request() {
        specificRequest();
    }
}
