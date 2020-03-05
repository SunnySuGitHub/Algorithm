package Class_1;

import java.math.BigInteger;

/**
 * Description:
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 应用插入排序的思想，进行逐个比较
 * Created by Administrator on 2019/1/8
 */
public class PrintMinNumber {
    public static void main(String[] args) {
        int[] arr = {3,32,321};
        System.out.println(printMinNumber(arr));
    }

    private static String printMinNumber(int[] nums) {
        if (nums.length == 0) return null;
        if (nums.length == 1) return String.valueOf(nums[0]);
        String res = "";
        BigInteger bigInteger = new BigInteger("0");
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            while (j >= 1 && (BigInteger.valueOf(Long.valueOf(String.valueOf(nums[j - 1]) + String.valueOf(nums[j])))
                    .subtract(BigInteger.valueOf(Long.valueOf(String.valueOf(nums[j]) + String.valueOf(nums[j - 1]))))
                    .compareTo(bigInteger)) == 1) {
                swap(nums, j - 1, j);
                j--;
            }
        }
        for(int k = 0; k < nums.length; k++){
            res = res + String.valueOf(nums[k]);
        }
        return res;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
