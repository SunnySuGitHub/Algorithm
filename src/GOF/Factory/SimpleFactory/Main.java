package GOF.Factory.SimpleFactory;

/**
 * Description:Algorithm
 * Created by Administrator on 2020/2/29
 */
public class Main {
    public static void main(String[] args) {
        Car car = CarFactory.produceCar("Audi");
        car.run();
    }
}

