package Class_3;

import java.util.Arrays;

/**
 * Description:用数组实现栈
 * <p>
 * Created by Administrator on 2019/3/19
 */
public class JavaStack {

    private int[] stack;
    private int size;//数组中存储元素的个数

    public JavaStack() {
        stack = new int[10];//数组初始元素为10个
    }

    //判断数组中是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //查看栈顶的元素
    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return stack[size - 1];
    }

    //取出栈顶的元素
    public int pop() {
        if (size > 0) {
            return stack[--size];
        } else {
            return Integer.MIN_VALUE;
        }
    }

    //新增元素
    public void push(int item) {
        ensureCapacity(size + 1);
        stack[size++] = item;
    }

    //检查数组的容量是否已满
    public void ensureCapacity(int size) {
        int len = stack.length;
        if (size > len) {
            int newLen = size + 10;//每次数组容量扩展10个
            stack = Arrays.copyOf(stack, newLen);
        }
    }

    public static void main(String[] args) {
        JavaStack stack = new JavaStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(6);
        stack.push(6);
        stack.push(6);
        stack.push(6);
        stack.push(6);
        stack.push(6);
        stack.push(6);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
