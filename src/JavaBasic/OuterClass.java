package JavaBasic;

/**
 * Description:Algorithm
 * Created by Administrator on 2019/3/20
 */
public class OuterClass {
    static int b;
    int c;
    static class InnerClass{
        static int a;
        public static void swap(){
            b = a;
        }
    }

    public static void main(String[] args) {
        InnerClass i = new InnerClass();
        i.swap();
    }
}

class II{


    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        Integer i = 5;
        Integer j = 5;
        System.out.println(i == j);
    }
}
