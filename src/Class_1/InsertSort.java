package Class_1;

/**
 * Description:插入排序
 * 时间复杂度O(N^2)
 * Created by Administrator on 2018/12/28
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {6,8,9,5,2,4,7};
        insertSort(arr);
        for(int item:arr){
            System.out.print(item);
        }
    }
    //插入排序类型与打扑克牌，边抽牌边排序
    private static void insertSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;//如果数组为空或者长度小于2，那么就不用排序
        }
        //i表示抽到第几张牌了，如果抽到第0张，不用排序，所以从1开始
        for(int i = 1; i < arr.length; i++){
            //j表示当前待插入的牌，j与之前的所有牌进行比较(之前的所有牌都是已经排好序的)
            int j = i;
            //如果后面的小于前面的，就交换他们，直到后面的大于前面的，由于是排好序的，到这里就可以停止了
            while(j >= 1 && arr[j] < arr[j - 1]){
                swap(arr,j,j - 1);
                j--;//j--后，j代表的还是之前插入的那张牌
            }
        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
