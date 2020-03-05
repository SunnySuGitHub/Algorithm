package Class_2;

/**
 * Description:全排列
 * Created by Administrator on 2019/3/27
 */
public class FullSort {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4};
        fullSort(arr, 0, arr.length - 1);
    }

    private static void fullSort(int[] arr, int L, int R){
        if(L == R){
            for(int i : arr){
                System.out.print(i);
            }
            System.out.print("\n");
            return;
        }


        for(int i = L; i <= R; i++){
            swap(arr, L, i);
            fullSort(arr, L + 1, R);
            swap(arr, L, i);
        }
    }


    private static void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
