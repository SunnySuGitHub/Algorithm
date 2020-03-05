package MyLearning.Jicheng;

/**
 * Description:Algorithm
 * Created by Administrator on 2020/2/24
 */
public class Animal {

    public int age = 2;
    public String name = "haha";

    MyInner inner = new MyInner(1, "1");

    public static MyInner InnerItem = new MyInner(5,"5");

    private int test = 1;

    public void change() {
        age = 5;
    }


}

class MyInner{
    int age;
    String name;

    public MyInner(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
