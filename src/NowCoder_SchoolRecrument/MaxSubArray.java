package NowCoder_SchoolRecrument;

/**
 * Description:Algorithm
 * Created by Administrator on 2019/3/2
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, -1};
        int max = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > 0) {
                if (nums[i] > 0) {
                    sum = Math.max(sum, nums[i]);
                    max = Math.max(sum, max);
                }
                max = Math.max(max, sum);
            } else {
                sum = nums[i];
                max = Math.max(sum, max);
            }
        }
        System.out.println(max);
    }
}

