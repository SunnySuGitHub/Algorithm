package NowCoder_SchoolRecrument;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Description:Algorithm
 * Created by Administrator on 2019/3/2
 */
public class findCoder {


    public static String[] findCoder(String[] A, int n) {
        // write code here
        List<Record> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int counts = 0;
            A[i] = A[i].toLowerCase();
            String[] strs = A[i].split(" ");
            for(int j = 0; j < strs.length; j++){
                if(strs[j].equals("coder")){
                    counts++;
                }
            }
            if(counts > 0){
                list.add(new Record(A[i], counts));
            }
        }
        //重写compare方法，想要小的排在前面就o1 - o2. 想要大的排在前面就o2 - o1
        Collections.sort(list, new Comparator<Record>(){
            @Override
            public int compare(Record r1, Record r2){
                return r2.getCount() - r1.getCount();
            }
        });
        String[] s = new String[list.size()];
        for(int k = 0; k < list.size(); k++){
            s[k] = list.get(k).getStr();
        }
        return s;
    }

    public static void main(String[] args) {
        String[] s = {"i am a coder","Coder Coder","Code"};
        String[] ss = findCoder(s, 3);
        for(String a : ss){
            System.out.println(a);
        }
    }
}

class Record{
    String str;
    int count;
    public Record(String str, int count){
        this.str  = str;
        this.count = count;
    }
    public int getCount(){
        return this.count;
    }

    public void add(){
        this.count++;
    }

    public String getStr(){
        return this.str;
    }
}
