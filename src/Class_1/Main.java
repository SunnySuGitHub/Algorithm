package Class_1;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Description:Algorithm
 * Created by Administrator on 2019/9/6
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int S = sc.nextInt();
        int T = sc.nextInt();
        int walk = 0;
        int blink = 0;
        for(int i = 1; i <= T; i++){
            walk += 13;
            if(M >= 10){
                M -= 10;
                blink += 50;
            } else {
                M += 4;
            }
            walk = Math.max(walk, blink);
            if(walk >= S){
                System.out.println("Yes");
                System.out.println(i);
                return;
            }
        }
        System.out.println("No");
        System.out.println(walk);
//        for(int i = 1; i <= T; i++){
//            if(M >= 10){
//                dp[i] = dp[i - 1] + 50;
//                M -= 10;
//            } else {
//                int need = 10 - M;
//                int back = need%4 == 0 ? need/4 : need/4 + 1;
//                if(dp[i - 1] + 13 > dp[i-back] + 50){
//                    dp[i] = dp[i-1] + 13;
//                } else {
//                    dp[i] = dp[i-back - 1] + 50;
//                    M = M + 4*back;
//                }
//            }
//        }
//        if(dp[T] >= S){
//            System.out.println("Yes");
//            int min = T;
//            for(int j = 0; j < dp.length; j++){
//                if(dp[j] >= S){
//                    min = j;
//                    break;
//                }
//            }
//            System.out.println(min);
//        } else {
//            System.out.println("No");
//            System.out.println(dp[T]);
//        }
    }

}
