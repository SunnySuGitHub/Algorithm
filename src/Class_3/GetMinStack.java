package Class_3;


import java.util.Stack;

/**
 * Description:实现一个栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
 * pop push getMin的时间复杂度都是O（1）
 * Created by Administrator on 2019/1/4
 */
public class GetMinStack {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(3);
        myStack.push(1);
        myStack.push(2);
        myStack.push(5);
        myStack.push(241);
        myStack.push(465);
        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.pop();
        System.out.println(myStack.getMin());
    }

    public static class MyStack {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        public void push(int item) {
            stack.push(item);
            if (!minStack.isEmpty()) {
                if (item >= minStack.peek()) {
                    minStack.push(minStack.peek());
                } else {
                    minStack.push(item);
                }
            } else {
                minStack.push(item);
            }
        }

        public int pop() {
            minStack.pop();
            return stack.pop();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}


