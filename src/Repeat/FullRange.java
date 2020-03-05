package Repeat;

/**
 * Description:全排列默写
 * Created by Administrator on 2019/3/31
 */
public class FullRange {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4};
        fullRange(arr, 0, arr.length - 1);
    }

    private static void fullRange(int[] arr, int L, int R){
        if (L == R){
            for(int i : arr){
                System.out.print(i);
            }
            System.out.print("\n");
        }

        for(int i = L; i <= R; i++){
            swap(arr, i, L);
            fullRange(arr, L + 1, R);
            swap(arr, i, L);
        }

    }

    private static void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
