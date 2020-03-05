package GOF.Decorator;

/**
 * Description:Algorithm
 * Created by Administrator on 2020/3/1
 */
abstract class Decorators implements Component {

    Component component;

    public Decorators(Component component) {
        this.component = component;
    }


}
