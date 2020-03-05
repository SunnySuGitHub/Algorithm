package NowCoder_SchoolRecrument;

/**
 * Description:二分查找
 * Created by Administrator on 2019/3/1
 */
public class BinarySearch {
    public static void main(String[] args) {
//        int[] arr = {9, 13, 21, 23, 31};
//        System.out.println(getPos(arr, arr.length, 31));
        String s1 = "dwadwasd";
        String s2 = s1.replace("wa", "@");
        System.out.println(s2);

    }

    public static int getPos(int[] A, int n, int val) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] > val) {
                high = mid - 1;
            } else if (A[mid] < val) {
                low = mid + 1;
            } else {
                while ((mid - 1) >= 0 && A[mid - 1] == val) {
                    mid--;
                }
                return mid;
            }
        }
        return -1;
    }
}
