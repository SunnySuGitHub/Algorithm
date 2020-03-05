package Repeat;


/**
 * Description:Algorithm
 * Created by Administrator on 2019/8/26
 */
public class Sort {

    public static void main(String[] args) {
        int[] arr = {6, 8, 9, 5, 2, 4, 7};
        quickSort(arr);
        for (int item : arr) {
            System.out.print(item);
        }
    }

    /**
     * 冒泡
     */
    private static void bubbleSort(int[] arr){
        if(arr == null || arr.length <= 1){
            return;
        }

        for(int i = arr.length - 1; i >= 0; i--){
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[j + 1]){
                    swap(arr, j, j + 1);
                }
            }
        }
        return;
    }

    /**
     * 插入
     */
    private static void insertSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }

        for(int i = 1; i < arr.length; i++){
            int now = i;
            while(now >= 1 && arr[now] < arr[now - 1]){
                swap(arr, now, now - 1);
                now--;
            }
        }
    }

    /**
     * 归并
     */
    private static void mergeSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int i, int j){
        if(i >= j){
            return;
        }
        int mid = (i + j)/2;
        sort(arr, i, mid);
        sort(arr, mid + 1, j);
        merge(arr, i, mid, j);
    }

    private static void merge(int[] arr, int L, int mid, int R){
        int[] tmp = new int[R- L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R){
            tmp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= mid){
            tmp[i++] = arr[p1++];
        }
        while (p2 <= R){
            tmp[i++] = arr[p2++];
        }
        for(int j = 0; j < tmp.length; j++){
            arr[L + j] = tmp[j];
        }
    }

    /**
     * 快排
     */
    private static void quickSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        qSort(arr, 0, arr.length - 1);
    }

    private static void qSort(int[] arr, int L, int R){
        if(L >= R){
            return;
        }

        int[] pointer = divide(arr, L, R);
        qSort(arr, L, pointer[0]);
        qSort(arr, pointer[1], R);
    }

    private static int[] divide(int[] arr, int L, int R){
        int less = L - 1;
        int more = R + 1;
        while (L < more){
            if(arr[L] < arr[R]){
                swap(arr, L++, ++less);
            } else if(arr[L] > arr[R]){
                swap(arr, L, --more);
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
