package JavaBasic;

import java.util.*;

/**
 * Description:Algorithm
 * Created by Administrator on 2019/9/1
 * 按照值排序
 * 单纯的按照key排序可以使用TreeMap
 * 如果需要按照value排序，使用普通的map即可，但是需要将entry转为List去排序
 */
public class ValueSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int round = sc.nextInt();
        for (int i = 0; i < round; i++) {
            int sum = sc.nextInt();
            HashMap<Integer, Integer> map = new HashMap();
            TreeMap<Integer, String> treeMap = new TreeMap<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;//倒序排列
                }
            });
            for (int j = 0; j < sum; j++) {
                int now = sc.nextInt();
                if (map.containsKey(now)) {
                    int cnt = map.get(now);
                    map.put(now, cnt + 1);
                } else {
                    map.put(now, 1);
                }
            }
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            });
            System.out.println(list.get(0).getValue() <= sum / 2);
        }
    }


}
