package Test;


/**
 * Description:Algorithm
 * Created by Administrator on 2019/5/22
 */
public interface InterfaceAndAbstract {
    void fun1();
    void fun2();
    int i = 1;
}

class A implements InterfaceAndAbstract{

    @Override
    public void fun1() {
        System.out.println(i);
    }

    @Override
    public void fun2() {

    }

    public static void main(String[] args) {
        A a = new A();
        a.fun1();
    }
}

/**
 * 接口和抽象类都可以定义变量，实现类会自动继承，
 *
 * 但是接口的方法和变量都是public修饰的，并且变量默认是static final类型，
 * 并且只能是static final类型，不可以在实现类中进行修改
 *
 * 抽象类的方法除了不可以用private修饰之外，用其他任何修饰符都可以，可以起到对实现类方法访问级别的控制
 * 抽象类的变量字段可修改，可以用任何修饰符修饰，如果用private，那么实现类将不能访问
 */
abstract class Abs{
    protected abstract void fun1();
    public abstract void fun2();
    protected void fun3(){
        System.out.println("fun3");
    }
    protected int j = 1;
}

class Real extends Abs{


    @Override
    public void fun1() {
        j++;
        System.out.println(j);
    }

    @Override
    public void fun2() {
        j++;
        System.out.println(j);
    }

    @Override
    public void fun3() {
        super.fun3();
    }

    public static void main(String[] args) {
        Real real = new Real();
        System.out.println(real.j);
        real.fun1();
        real.fun2();
        real.fun3();
    }
}
