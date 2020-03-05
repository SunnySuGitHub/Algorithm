package Class_4;

/**
 * Description:之字形打印二维数组
 * Created by Administrator on 2019/1/5
 */
public class ZigZagPrintMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {11, 12, 13, 14}};
        printMatrixZigZag(arr);
    }

    private static void printMatrixZigZag(int[][] matrix) {
        int aH = 0;
        int aL = 0;
        int bH = 0;
        int bL = 0;
        int endH = matrix.length - 1;
        int endL = matrix[0].length - 1;
        boolean fromUp = false;
        while (aH <= endH) {
            printLevel(matrix, aH, aL, bH, bL, fromUp);
            aH = aL == endL ? aH + 1 : aH;//列作为判断条件，先进行行的修改
            aL = aL == endL ? aL : aL + 1;
            bL = bH == endH ? bL + 1 : bL;//行作为判断条件，先进行列的修改
            bH = bH == endH ? bH : bH + 1;
            fromUp = !fromUp;
        }
    }

    private static void printLevel(int[][] m, int aH, int aL, int bH, int bL, boolean fromUp) {
        if (fromUp) {
            while (aH <= bH) {
                System.out.println(m[aH][aL]);
                aH++;
                aL--;
            }
        } else {
            while (aH <= bH) {
                System.out.println(m[bH][bL]);
                bH--;
                bL++;
            }
        }
    }
}
