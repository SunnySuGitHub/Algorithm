package Class_2;

/**
 * Description:Algorithm
 * Created by Administrator on 2019/3/23
 */
public class QucikSort {
    public static void main(String[] args) {
        int[] arr = {2, 5, 4, 41, 12, 34, 4, 99};
        sort(arr, 0, arr.length - 1);
        for (int item : arr) {
            System.out.println(item);
        }
    }

    public static void sort(int[] arr, int L, int R){
        if(L < R){
            int[] res = partition(arr, L, R);
            sort(arr, L, res[0]);
            sort(arr, res[1], R);
        }
    }

    public static int[] partition(int[] arr, int L, int R){
        int less = L - 1;
        int more = R + 1;
        while(L < more){
            if(arr[L] > arr[R]){
                swap(arr, L, --more);
            } else if(arr[L] < arr[R]){
                swap(arr, L++, ++less);
            } else {
                L++;
            }
        }
        return new int[]{less, more};
    }

    public static void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
