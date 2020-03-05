package Repeat;

/**
 * Description:二分查找默写
 * Created by Administrator on 2019/3/31
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {9, 13, 21, 23, 31, 45};
        System.out.println(binarySearch(arr, 22));
    }

    public static int binarySearch(int[] arr, int target){
        int head = 0;
        int tail = arr.length - 1;
        while(head <= tail){
            int mid = (head + tail) / 2;
            if(arr[mid] == target){
                return mid;
            } else if(target < arr[mid]){
                tail = mid - 1;
            } else if(target > arr[mid]){
                head = mid + 1;
            }
        }
        return -1;
    }
}
