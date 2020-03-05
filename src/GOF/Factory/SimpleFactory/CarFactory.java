package GOF.Factory.SimpleFactory;

/**
 * Description:Algorithm
 * Created by Administrator on 2020/3/1
 */
class CarFactory{
    public static Car produceCar(String type) {
        if(type.equals("Audi")) return new Audi();
        else if(type.equals("BMW")) return new BMW();
        else return null;
    }
}
