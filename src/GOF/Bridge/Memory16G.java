package GOF.Bridge;

/**
 * Description:Algorithm
 * Created by Administrator on 2020/3/1
 */
class Memory16G implements Memory {
    @Override
    public void showMemory() {
        System.out.println("是16G");
    }
}
