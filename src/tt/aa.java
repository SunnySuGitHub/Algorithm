package tt;

/**
 * Description:枚举类的构造函数是private的，不可以被new，枚举类的内容都是单例的
 * Created by Administrator on 2019/3/27
 */
public class aa {
    public static void main(String[] args) {
        Color color = Color.RED;
        Color color2 = Color.GREEN;
        Color color3 = Color.BLUE;
        Color[] colors = Color.values();
        for(Color color1 : colors) {
            System.out.println(color1);
        }
        System.out.println(Singleton.INSTANCE.hashCode());
    }

    enum Color{

        RED(1, "红色"),
        GREEN(2,"绿色"),
        BLUE(3,"蓝色");

        private int type;
        private String desc;

        Color(int type, String desc){
            this.type = type;
            this.desc = desc;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc){
            this.desc = desc;
        }

        @Override
        public String toString(){
            return type + " " + desc;
        }
    }
}

enum Singleton{
    INSTANCE
}
