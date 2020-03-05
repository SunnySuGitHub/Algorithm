package GOF.Bridge;

/**
 * Description:Algorithm
 * Created by Administrator on 2020/3/1
 */
class RGBComputer extends Computer {
    @Override
    void using() {
        System.out.println("GRB电脑,");
        memory.showMemory();
    }
}
