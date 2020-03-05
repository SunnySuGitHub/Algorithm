package Class_3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:用两个队列实现一个栈结构
 * 队列的实现： Queue<Integer> que = new LinkedList<Integer>();
 * add是向队列里面添加元素，poll是从队列里面删除元素
 * Created by Administrator on 2019/1/4
 */
public class TwoQueuesStack {
    public static void main(String[] args) {
        QueueStack tt = new QueueStack();
        tt.push(2);
        tt.push(3);
        tt.push(4);
        tt.push(6);
        tt.push(1);
        System.out.println(tt.pop());
        System.out.println(tt.pop());
        System.out.println(tt.peek());
        System.out.println(tt.pop());
        System.out.println(tt.peek());
        System.out.println(tt.pop());
        System.out.println(tt.pop());
    }

    public static class QueueStack {
        private Queue<Integer> data;
        private Queue<Integer> help;

        public QueueStack() {
            data = new LinkedList<Integer>();
            help = new LinkedList<Integer>();
        }

        public void push(int pushInt) {
            data.add(pushInt);
        }

        public int pop() {
            while (data.size() > 1) {
                help.add(data.poll());
            }
            int ret = data.poll();
            swapQueue();
            return ret;
        }

        public int peek() {
            while (data.size() > 1) {
                help.add(data.poll());
            }
            int ret = data.peek();
            help.add(data.poll());
            swapQueue();
            return ret;
        }

        private void swapQueue() {
            Queue<Integer> temp = data;
            data = help;
            help = temp;
        }
    }
}


