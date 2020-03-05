package GOF.Bridge;

/**
 * Description:Algorithm
 * Created by Administrator on 2020/3/1
 */
class Memory8G implements Memory {
    @Override
    public void showMemory() {
        System.out.println("是8G");
    }
}
