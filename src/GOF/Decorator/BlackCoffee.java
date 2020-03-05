package GOF.Decorator;

/**
 * Description:Algorithm
 * Created by Administrator on 2020/3/1
 */
class BlackCoffee implements Component {
    double cost;

    public BlackCoffee() {
        cost = 20.0;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public String getDescription() {
        return "黑咖啡";
    }
}
