package Class_1;

/**
 * Description:冒泡排序
 * 时间复杂度O(N^2)
 * Created by Administrator on 2018/12/28
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {6, 8, 9, 5, 2, 4, 7};
        bubbleSort(arr);
        for (int item : arr) {
            System.out.print(item);
        }
    }

    private static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;//如果数组为空或者长度小于2，那么就不用排序
        }
        for (int end = arr.length - 1; end > 0; end--) {
            //以end作限，经过下面操作，最大的数会被移动到最后，那么下一次排序的时候就可以不考虑已经排好的序
            for (int i = 0; i < end; i++) {
                //如果前一个数比后一个数大，那么交换他们的位置，使大的数在后面
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
