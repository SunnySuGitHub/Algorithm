package GOF.Adaptee.ObjectAdaptee;

/**
 * Description:Algorithm
 * Created by Administrator on 2020/3/1
 */
class Adaptor implements Target {

    Adaptee adaptee;

    public Adaptor(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}
