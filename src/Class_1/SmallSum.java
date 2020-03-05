package Class_1;

/**
 * Description:小和问题:：在随机数组大小的数组中，找出左边比右边元素小的所有元素之和
 * 运用归并排序的思想，在排好序之后知道有多少个数比当前数要大，用merge一次性、分批量、不重复的计算出所有的小和
 * 先计算小和再排序，排序的作用是便于下一次计算小和
 * 看的是每个数被计算出多少小和
 * 归并排序体现的是集团合并、分治的概念
 * Created by Administrator on 2018/12/28
 */
public class SmallSum {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5};
        System.out.println(smallSum(arr));
    }

    private static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int mergeSort(int[] arr, int l, int r) {//返回的是l到r的位置上产生了多少小和
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return mergeSort(arr, l, mid)//执行完此行，左侧已经排好序并已计算出左侧小和，返回
                + mergeSort(arr, mid + 1, r)//执行完此行，右侧已经排好序并已计算出右侧小和，返回
                + merge(arr, l, mid, r);//执行完此行，返回左右合在一起的小和
    }

    private static int merge(int[] arr, int L, int mid, int R) {
        //辅助数组
        int[] help = new int[R - L + 1];
        //辅助数组的指针
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        int res = 0;
        while (p1 <= mid && p2 <= R) {
            res += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        //数组复制到arr
        for(int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
        return res;
    }
}
