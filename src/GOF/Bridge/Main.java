package GOF.Bridge;

/**
 * Description:Algorithm
 * Created by Administrator on 2020/3/1
 * 应用组合关系将事务拆分成不同纬度，抽象与实现分离
 */
public class Main {
    public static void main(String[] args) {
        Computer computer = new RGBComputer();
        computer.setMemory(new Memory16G());
        computer.using();
    }
}


