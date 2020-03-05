package GOF.Decorator;

/**
 * Description:Algorithm
 * Created by Administrator on 2020/3/1
 */
class Milk extends Decorators {

    public Milk(Component component) {
        super(component);
    }

    @Override
    public double getCost() {
        return component.getCost() + 1.0;
    }

    @Override
    public String getDescription() {
        return component.getDescription() + "加奶";
    }
}
