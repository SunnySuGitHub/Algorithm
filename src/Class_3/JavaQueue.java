package Class_3;

/**
 * Description:数组实现队列
 * 一个头指针和一个尾指针，每次添加操作尾指针后移，移除操作头指针后移
 * Created by Administrator on 2019/3/19
 */
public class JavaQueue {
    public int front = -1;//队首
    public int real = -1;//队尾
    public int size = 100;
    public int[] arrays;

    public JavaQueue(int size) {
        this.size = size;
        arrays = new int[size];
    }

    public JavaQueue() {
        arrays = new int[size];
    }

    public void offer(int data) {
        /**
         * 还有空余
         */
        if (real < size) {
            arrays[++real] = data;
        }
    }

    public int poll() {
        /**
         * 队首不等于队尾
         * 或者说
         * 队首小于队尾
         */
        if (front != real) {
            return arrays[++front];
        } else{
             return Integer.MIN_VALUE;
        }
    }

    public void display() {
        for (int i = front + 1; i <= real; i++) {
            System.out.println(arrays[i]);
        }
    }

    public boolean isEmpty() {
        /**
         * 队首和队尾的指针比较造成了假溢出的问题
         */
        return front == real;
    }

    public static void main(String[] args) {
        JavaQueue queue = new JavaQueue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
