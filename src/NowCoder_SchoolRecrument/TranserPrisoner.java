package NowCoder_SchoolRecrument;

import java.util.*;

/**
 * Description:Algorithm
 * Created by Administrator on 2019/3/1
 */
public class TranserPrisoner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
            int n = sc.nextInt();//总共n名罪犯
            int t = sc.nextInt();//罪行值上限t
            int c = sc.nextInt();//转移人数c
            int[] sin = new int[n];
            for(int i = 0; i < n ;i++){
                sin[i] = sc.nextInt();
            }
            int count = 0;
            int sum = 0;
            for(int i = 0; i < c; i++){
                sum += sin[i];
            }
            int[][] dp = new int[n][n];
            dp[0][c - 1] = sum;
            if(sum <= t) count++;
            for(int i = 1; i <= n - c; i++){
                int j = i + c - 1;
                if(j <= n){
                    dp[i][j] = dp[i - 1][j - 1] - sin[i - 1] + sin[j];
                } else break;
                if(dp[i][j] <= t) count++;
            }
            System.out.println(count);
//        }
    }
}
