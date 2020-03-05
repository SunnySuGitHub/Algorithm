package GOF.Decorator;

/**
 * Description:Algorithm
 * Created by Administrator on 2020/3/1
 */
class Sugar extends Decorators {

    public Sugar(Component component) {
        super(component);
    }

    @Override
    public double getCost() {
        return component.getCost() + 1.5;
    }

    @Override
    public String getDescription() {
        return component.getDescription() + "加糖";
    }
}
