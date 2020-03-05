package Class_2;

/**
 * Description:经典快速排序
 * Created by Administrator on 2018/12/31
 */
public class ClassicalQuickSort {
    public static void main(String[] args) {
        int[] arr = {2, 5, 4, 41, 12, 34, 4, 99};
        quickSort(arr, 0, arr.length - 1);
        for (int item : arr) {
            System.out.println(item);
        }
    }

    /**
     * 快排
     */
    private static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0]);
            quickSort(arr, p[1], R);
        }
    }

    /**
     * 对于数组arr，从索引L到R，以最后一个为基准进行分离
     */
    private static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R + 1;
        while (L < more) {
            if (arr[L] < arr[R]) {
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                swap(arr, L, --more);
            } else {
                L++;
            }
        }

        return new int[]{less, more};
    }

    private static void swap(int[] arr, int L, int R) {
        int temp = arr[L];
        arr[L] = arr[R];
        arr[R] = temp;
    }
}
