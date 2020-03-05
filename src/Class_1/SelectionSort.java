package Class_1;

/**
 * Description:选择排序
 * 时间复杂度O(N^2)
 * Created by Administrator on 2018/12/28
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {6, 8, 9, 5, 2, 4, 7};
        selectionSort(arr);
        for (int item : arr) {
            System.out.print(item);
        }
    }

    private static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;//如果数组为空或者长度小于2，那么就不用排序
        }
        //选择排序是从第一个开始，遍历整个数组，选择出当前趟的最小值，放在前面
        for (int i = 0; i < arr.length - 1; i++) {
            //最小索引保存这一趟最小值的索引，先假设最小索引是当前索引的，然后开始比较
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                //j一直增加，如果arr[j] < arr[minIndex]，那么将minIndex改为j，这一趟下来之后minIndex肯定是i之后的最小值
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
