package Class_4;
import java.util.*;
/**
 * Description:Algorithm
 * Created by Administrator on 2019/1/10
 */
public class Permutations {
    public static void main(String[] args) {

    }

    private static ArrayList<String> getPermutations(String str){
        char[] arr = str.toCharArray();
        ArrayList<String> res = new ArrayList<>();
        Arrays.sort(arr);
        permutations(res, 0, arr);
        Collections.sort(res);
        return res;
    }

    private static void permutations(ArrayList res, int index, char[] arr){
        if(index == arr.length - 1){
            String s = new String(arr);
            if(res.contains(s)){
                return;
            } else {
                res.add(s);
                return;
            }
        }
        for(int i = 0; i < arr.length; i++){
            swapChar(arr, i, index);
            permutations(res, index + 1, arr);
            swapChar(arr, i, index);
        }
    }

    private static void swapChar(char[] arr, int a, int b){
        char c = arr[a];
        arr[a] = arr[b];
        arr[b] = c;
    }
}
