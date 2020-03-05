package Class_3;

import java.util.Stack;

/**
 * Description:用两个栈实现一个队列
 * Created by Administrator on 2019/1/4
 */
public class TwoStackQueue {
    public static void main(String[] args) {
        StackQueue stackQueue = new StackQueue();
        stackQueue.add(1);
        stackQueue.add(2);
        stackQueue.add(3);
        stackQueue.add(4);
        stackQueue.add(5);
        System.out.println(stackQueue.poll());
        System.out.println(stackQueue.poll());
        stackQueue.add(6);
        stackQueue.add(8);
        System.out.println(stackQueue.poll());
        System.out.println(stackQueue.poll());
        System.out.println(stackQueue.poll());
        System.out.println(stackQueue.poll());
        System.out.println(stackQueue.poll());
    }

    public static class StackQueue {
        private Stack<Integer> pushStack;
        private Stack<Integer> popStack;

        public StackQueue() {
            pushStack = new Stack<>();
            popStack = new Stack<>();
        }

        public void add(int item) {
            while (!popStack.isEmpty()) {
                pushStack.push(popStack.pop());
            }
            pushStack.push(item);
        }

        public int poll() {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
            return popStack.pop();
        }
    }
}


