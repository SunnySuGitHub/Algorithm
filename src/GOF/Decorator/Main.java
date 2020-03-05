package GOF.Decorator;

/**
 * Description:Algorithm
 * Created by Administrator on 2020/3/1
 */
public class Main {
    public static void main(String[] args) {
        Component component = new BlackCoffee();
        component = new Sugar(component);
        component = new Milk(component);
        component = new Large(component);
        System.out.println(component.getDescription());
        System.out.println(component.getCost());
    }
}
