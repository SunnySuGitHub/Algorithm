package Class_5;
import java.math.BigDecimal;
import java.util.*;
/**
 * Description:Algorithm
 * Created by Administrator on 2019/4/3
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] times = new int[10];//0~9每个数字可用次数
        for(int i = 0; i < 10; i++){
            times[i] = sc.nextInt();
        }
        int A = sc.nextInt();//A的位数 1 <=A/B<= 9
        int B = sc.nextInt();//B的位数
        if(A <= B){
            System.out.println(get(A, B, times));//先分配小的
        } else {
            System.out.println(get(B, A, times));
        }
    }

    private static int get(int A, int B, int[] times){
        String A_str = "";
        String B_str = "";
        int j = 0;
        while(A > 0){
            if(A >= times[j]){
                if(times[j] == 0) continue;
                A = A - times[j];
                for(int i = 0 ; i < times[j]; i++){
                    A_str += j;
                }
            } else {
                if(times[j] == 0) continue;
                for(int i = 0; i <= A; i++){
                    A_str += j;
                    A--;
                    times[j]--;
                }
                break;
            }
            j++;
        }
        while(B > 0){
            if(B >= times[j]){
                if(times[j] == 0) continue;
                B = B - times[j];
                for(int i = 0 ; i < times[j]; i++){
                    B_str += j;
                }
            } else {
                if(times[j] == 0) continue;
                for(int i = 0; i <= B; i++){
                    B_str += j;
                    B--;
                    times[j]--;
                }
                break;
            }
            j++;
        }
        return Integer.valueOf(A_str) * Integer.valueOf(B_str);
    }
}
