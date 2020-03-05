package Class_2;

/**
 * Description:荷兰国旗问题
 * arr中比num小的数都放在arr的左边，比num大的数都放在num的右边，相等的放在中间
 * Created by Administrator on 2018/12/29
 */
public class Flag {
    public static void main(String[] args) {
        int[] arr = {2, 5, 4, 41, 12, 34, 4, 99};
        int num = 12;
        holandFlag(arr, num);
        for (int item : arr) {
            System.out.println(item);
        }
    }

    /**
     * 荷兰国旗
     */
    private static void holandFlag(int[] arr, int num) {
        int less = -1;
        int more = arr.length;
        int i = 0;
        while (i < more) {
            if (arr[i] < num) {
                swap(arr, ++less, i);
                i++;
            } else if (arr[i] > num) {
                swap(arr, i, --more);
            } else {
                i++;
            }
        }
    }

    /**
     * 小的放左边，大的放右边
     */
    private static void sort(int[] arr, int num) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= num) {
                swap(arr, ++index, i);
            }
        }
    }

    private static void swap(int[] arr, int L, int R) {
        int temp = arr[L];
        arr[L] = arr[R];
        arr[R] = temp;
    }
}
