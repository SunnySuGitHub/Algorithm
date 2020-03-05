package Test;

/**
 * Description:Algorithm
 * Created by Administrator on 2019/5/21
 */
public class BasicType {
    public static void main(String[] args) {
        Integer i1 = new Integer(123);
        Integer i2 = Integer.valueOf(123);
        System.out.println(i1 == i2);
        String a = "";
        a.intern();
        System.out.println(Integer.valueOf(String.valueOf('2')));
    }
}
