package GOF.Factory.FactoryMethod;

/**
 * Description:Algorithm
 * Created by Administrator on 2020/3/1
 */
class HuaweiFactory implements PhoneFactory{
    @Override
    public Phone porducePhone() {
        return new Huawei();
    }
}
