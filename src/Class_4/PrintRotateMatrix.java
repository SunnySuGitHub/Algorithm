package Class_4;

/**
 * Description:旋转打印二维矩阵,宏观调度问题，分圈结构
 * 取两个点，左上角的点和右下角的点，每次以这两个点的坐标做界限打印数组
 * 打印完一圈后左上角的点向右下角移动一个，右下角的点向左上角移动一个。
 * Created by Administrator on 2019/1/5
 */
public class PrintRotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {11, 12, 13, 14}};
        spiralOrderPrint(matrix);
    }

    private static void spiralOrderPrint(int[][] matrix) {
        int lR = 0;//左上角元素所在行
        int lC = 0;//左上角元素所在列
        int rR = matrix.length - 1;//右下角元素所在行
        int rC = matrix[0].length - 1;//右下角元素所在列
        while (lR <= rR && lC <= rC) {
            printEdge(matrix, lR++, lC++, rR--, rC--);
        }
    }

    private static void printEdge(int[][] m, int lR, int lC, int rR, int rC) {
        if (lR == rR) {//左上角元素和右下角元素在同一行，只需从左到右顺序打印每列的元素
            for (int i = lC; i <= rC; i++) {
                System.out.print(m[lR][i] + " ");
            }
        } else if (lC == rC) {//左上角元素和右下角元素在同一列，只需从上到下顺序打印每行的元素
            for (int i = lR; i <= rR; i++) {
                System.out.print(m[i][lC] + " ");
            }
        } else {//普通情况
            int curC = lC;
            int curR = lR;
            while (curC < rC) {
                System.out.print(m[lR][curC++]);
            }
            while (curR < rR) {
                System.out.print(m[curR++][rC]);
            }
            while (curC > lC) {
                System.out.print(m[rR][curC--]);
            }
            while (curR > lR) {
                System.out.print(m[curR--][lC]);
            }
        }
    }
}
