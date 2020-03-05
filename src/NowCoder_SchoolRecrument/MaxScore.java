package NowCoder_SchoolRecrument;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Description:Algorithm
 * Created by Administrator on 2019/2/28
 */
public class MaxScore {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int stus = sc.nextInt();
        int oprs = sc.nextInt();
        int[] scores = new int[stus];
        List<Integer> res = new ArrayList<>();
        for(int i = 0 ; i < stus; i++){
            scores[i] = sc.nextInt();
        }
        for(int i = 0; i < oprs; i++){
            String ops = sc.next();
            int one = sc.nextInt();
            int two = sc.nextInt();
            if(ops.equals("Q")){
                if(one > two){
                    int temp = one;
                    one = two;
                    two = temp;
                }
                res.add(Max(scores, one - 1, two - 1));
            } else {
                scores[one - 1] = two;
            }
        }
        for(int item : res){
            System.out.println(item);
        }
    }

    private static int Max(int[] score, int i, int j){
        int ret = score[i];
        for(int k = i ; k <= j; k++){
            ret = Math.max(ret, score[k]);
        }
        return ret;
    }
}
