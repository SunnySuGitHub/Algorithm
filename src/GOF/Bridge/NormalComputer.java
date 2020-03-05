package GOF.Bridge;

/**
 * Description:Algorithm
 * Created by Administrator on 2020/3/1
 */
class NormalComputer extends Computer {
    @Override
    void using() {
        System.out.println("普通电脑,");
        memory.showMemory();
    }
}
