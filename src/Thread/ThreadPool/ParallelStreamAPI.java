package Thread.ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Description:Algorithm
 * Created by Administrator on 2019/2/27
 */
public class ParallelStreamAPI {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        Random r = new Random();
        for(int i = 0; i < 10000; i++){
            nums.add(100000 + r.nextInt(1000000));
        }

        long start = System.currentTimeMillis();
        nums.forEach(num -> isPrime(num));
        for(int num : nums){
            ParallelStreamAPI.isPrime(num);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        start = System.currentTimeMillis();
        nums.parallelStream().forEach(ParallelStreamAPI::isPrime);
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }


    static boolean isPrime(int num){
        for(int i = 2; i <= num/2;i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}
