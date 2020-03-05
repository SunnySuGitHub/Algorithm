package GOF.Bridge;

/**
 * Description:Algorithm
 * Created by Administrator on 2020/3/1
 */
abstract class Computer {
    Memory memory;

    public void setMemory(Memory memory) {
        this.memory=memory;
    }

    abstract void using();
}
