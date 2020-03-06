package New_Feature.Optional;

import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Description:Algorithm
 * Created by Administrator on 2020/3/6
 */
public class LearnOfOptional {
    @Test
    public void test_empty() {
        Optional optional = Optional.empty();
        System.out.println(optional.get());
    }

    @Test
    public void test_of() {
        String name = "suxinyu";
        Optional<String> has = Optional.of(name);
        System.out.println(has.isPresent());
        Optional<String> hasNot = Optional.of(null);
        System.out.println(hasNot.isPresent());
    }

    @Test
    public void test_ofNullable() {
        String name = "suxinyu";
        Optional<String> has = Optional.ofNullable(name);
        System.out.println(has.isPresent());
        Optional<String> hasNot = Optional.ofNullable(null);
        System.out.println(hasNot.isPresent());
    }

    @Test
    public void test_get() {
        List<User> list = new ArrayList<>();
        list.add(new User(23, "suxinyu"));
        Optional optional = list.stream().findFirst();
        System.out.println(optional.get());
    }

    @Test
    public void test_isPresent() {
        List<User> list = new ArrayList<>();
        System.out.println(list.stream().findFirst().isPresent());
        list.add(new User(23, "suxinyu"));
        System.out.println(list.stream().findFirst().isPresent());
    }

    @Test
    public void test_ifPresent() {
        List<User> list = new ArrayList<>();
        list.add(new User(23, "suxinyu"));
        list.stream().findFirst().ifPresent(System.out::println);
    }

    @Test
    public void givenPresentValue_whenCompare_thenOk() {
        User user = new User(23, "suxinyu");
        User result = Optional.ofNullable(user).orElse(createNewUser());
        User result2 = Optional.ofNullable(user).orElseGet(() -> createNewUser());
    }

    private static User createNewUser() {
        System.out.println("创建了方妮");
        return new User(24, "fangni");
    }



    private static class User {
        int age;
        String name;

        public User(int age, String name) {
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
    }
}
