package JavaBasic;

import java.util.*;

/**
 * Description:Algorithm
 * Created by Administrator on 2019/6/4
 */
public class Comparator_selfMade {
    public static void main(String[] args) {
        Person p1 = new Person(1, "haha");
        Person p2 = new Person(2, "haha");
        HashSet<Person> set = new HashSet();
        set.add(p1);
        set.add(p2);
        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getAge() - o1.getAge();
            }
        });
        for(Person p : list){
            System.out.println(p);
        }
    }

}

class Person{
    private int age;
    private String name;

    public Person(){

    }

    public Person(int age, String name){
        this.age = age;
        this.name = name;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return name + " " + age;
    }
}