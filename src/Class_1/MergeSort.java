package Class_1;

/**
 * Description:归并排序
 * 时间复杂度O(N*logN)
 * Created by Administrator on 2018/12/28
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {6, 8, 9, 5, 2, 4, 7};
        sort(arr, 0, arr.length - 1);
        for (int item : arr) {
            System.out.print(item);
        }
    }

    //sort方法就是先给L到R分块，然后进行排序
    //最基础的情况就是一共两个数据，每一个数据都是L==R，直接结束。之后将两个进行排序
    private static void sort(int[] arr, int L, int R) {
        if (L == R) {
            return;//如果L==R，直接结束
        }
        int mid = (L + R) / 2;
        sort(arr, L, mid);
        sort(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    //merge方法是给arr数组中索引从L到R，以mid分界的两块进行合并排序(其中L部分和R部分都已经各自排好序了)
    //因为第一次调用merge方法是将两个排序，一直到后面多个数据进行排序
    private static void merge(int[] arr, int L, int mid, int R) {
        //辅助数组
        int[] help = new int[R - L + 1];
        int i = 0;//辅助数组的指针
        int p1 = L;//L部分的指针
        int p2 = mid + 1;//R部分的指针，从mid+1开始的
        while (p1 <= mid && p2 <= R) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //执行完此while循环，p1和p2必有一个已经越界
        //将另一个未越界的所有数据添加到辅助数组中
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        //将排好序的辅助数组内容复制到arr的对应位置，arr数组从L位置开始的
        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
    }
}
