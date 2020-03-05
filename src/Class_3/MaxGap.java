package Class_3;

/**
 * Description:找出排序后的数组的相邻最大间距
 * N个数用N + 1个桶
 * Created by Administrator on 2019/1/3
 */
public class MaxGap {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 6, 7, 8};
//        int max = Integer.MIN_VALUE;
//        for(int i = 0; i < arr.length - 1; i++){
//            max = Math.max(max, (arr[i + 1] - arr[i]));
//        }
//        System.out.println(max);
        System.out.println(maxGap(arr));
    }

    private static int maxGap(int[] nums) {

        if (nums == null || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {//遍历整个数组找出最大最小值
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }
        if (min == max) {
            return 0;
        }
        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        int bid = 0;
        //遍历数组中每一个数，将他们分配进各个桶中，bid代表几号桶
        for (int j = 0; j < len; j++) {
            bid = bucket(nums[j], len, min, max);//bid代表nums[j]在第几号桶
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[j]) : nums[j];//bid号桶的最小值
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[j]) : nums[j];//bid号桶的最大值
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        for (int k = 1; k <= len; k++) {
            if (hasNum[k]) {
                res = Math.max(res, mins[k] - lastMax);
                lastMax = maxs[k];
            }
        }
        return res;
    }

    //确定输入的num来自于第几号桶
    private static int bucket(int num, int len, int min, int max) {
        return (int) ((num - min) * len / (max - min));
    }
}
