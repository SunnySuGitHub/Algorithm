package Class_2;

/**
 * Description:堆排序 时间复杂度:N*logN
 * Created by Administrator on 2019/1/3
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {2, 5, 4, 41, 12, 34, 4, 99};
        heapSort(arr);
        for (int item : arr) {
            System.out.println(item);
        }
    }

    private static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        /**
         * 建立大根堆的过程
         * 节点数为N，整个树的高度为logN
         * 建立大根堆的时间复杂度为log1 + log2 + log3 + ... + logN = O(N)
         */
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        //至此所有数组中所有值已经完成了堆构造，已经是一个大根堆结构
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);//现在0位置上的数是heap末尾交换上来的值，将这个数进行堆调整，再次将0位置上的数调整为最大值
            swap(arr, 0, --heapSize);//每次将最大的数交换到heap末尾
        }
    }

    /**
     * 构造堆
     * 实现arr数组中索引为index的数插入大根堆
     * 向上浮的过程
     */
    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {//index代表当前插入的数，一直跟踪
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * 调整堆
     * 0~heapSize上已经形成了堆，其中有数字突然改变，如何调整这个大根堆
     * 想象成为改变的数往下沉的过程
     */
    private static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {//左孩子没有越界
            //右孩子没有越界并且右孩子比左孩子大，largest赋值为右孩子的下标，否则为左孩子的下标
            int largest = (left + 1 < heapSize && arr[left + 1] > arr[left]) ? left + 1 : left;//得到左右孩子中最大数的下标


            //判断index和他的两个孩子之间最大的数，最大的数的下标为largest
            largest = arr[index] < arr[largest] ? largest : index;//得到
            if (largest == index) {
                break;//如果最大的就是index，潜台词就是即使变化了但是不影响整个堆的结构，index还是最大的，那么就break
            }
            swap(arr, largest, index);// 执行到这里代表largest != index，即结构发生了变化
            index = largest;//index始终跟踪的是当前插入的数
            left = index * 2 + 1;//为了进行下一次while循环比较
        }
    }

    private static void swap(int[] arr, int L, int R) {
        int temp = arr[L];
        arr[L] = arr[R];
        arr[R] = temp;
    }
}
