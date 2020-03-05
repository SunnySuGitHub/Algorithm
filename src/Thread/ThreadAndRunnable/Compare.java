package Thread.ThreadAndRunnable;

import java.util.Comparator;
import java.util.Map;

/**
 * Description:Algorithm
 * Created by Administrator on 2019/8/4
 */
public class Compare {

    static class SizeComprare implements Comparator<Map.Entry<String, Integer>>{

        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            return o1.getValue() - o2.getValue();
        }

        ThreadLocal local = new ThreadLocal();
        public void test(){
            local.set(1);
        }
    }


}
