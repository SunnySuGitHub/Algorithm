package NowCoder_SchoolRecrument;
import java.math.*;

import sun.security.util.BitArray;

import java.util.BitSet;

/**
 * Description:Algorithm
 * Created by Administrator on 2019/2/28
 */
public class KnowBinary {
    public static void main(String[] args) {
        int a = 1999;
        int b = 2299;
        String str = Integer.toBinaryString(a ^ b);
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '1'){
                count++;
            }
        }
        System.out.println(count);
    }
}
