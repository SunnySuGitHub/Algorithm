## Optional学习
    Optional是一个可装Null值或非Null值的容器
    如果是非Null值，使用isPresent()方法会返回true，并且使用get()方法返回该值

    基于值是否出现，还提供了附加的方法。例如orElse()方法，如果值未出现时，将返回默认值。
    ifPresent()方法如果值存在时可执行一个代码块。


### 主动创建Optional实例
    1、创建空的Optional
        Optional.empty()方法
    2、of()和ofNullable()方法用于创建包含值的Optional，两者的区别在于如果把null值作为参数传进去。
        of()方法会抛出异常；
        所以在明确对象非null时使用of()，不确定时使用ofNullable()。
### 获取Optional对象的值
#### 使用get()方法直接获取值，如果值为null会抛出异常
#### 使用orElse()方法获取optional对象的值，如果不存在则指定默认值返回。括号内传入默认值
#### 使用orELseGet()方法获取optional对象的值，与orElse()方法类似，但是前者括号内是函数式编程风格
    如果optional对象值为null，则两者之间无太大差别，但是如果optional对象不为null，orElse()方法依旧会执行括号内的操作，而orElseGet()则不会

Optional主要用在返回值的接收上，其中一个非常有用的例子就是：将Optional与stream API相结合，以构建流畅的代码
```
public void whenEmptyStream_thenReturnDefaultOptional() {
    List<User> users = new ArrayList<>();
    User user = users.stream().findFirst().orElse(new User("default", "1234"));

    assertEquals(user.getEmail(), "default");
}
```