package Class_4;

/**
 * Description:将一个二维数组方针进行顺时针旋转，并且空间复杂度为O(1)
 * 宏观调度问题，分圈结构
 * Created by Administrator on 2019/1/5
 */
public class RotateMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 123}, {4, 5, 6, 456}, {7, 8, 9, 789}, {23, 23, 23, 23}};
        rotateMatrix(arr);
    }

    private static void rotateMatrix(int[][] matrix) {
        int lR = 0;
        int lC = 0;
        int rR = matrix.length - 1;
        int rC = matrix[0].length - 1;
        while (lR <= rR && lC <= rC) {
            rotateNum(matrix, lR++, lC++, rR--, rC--);
        }
    }

    private static void rotateNum(int[][] matrix, int lR, int lC, int rR, int rC) {
        int cur1 = lC;
        int cur2 = lR;
        int cur3 = rC;
        int cur4 = rR;
        if (lR > rR && lC > rC) {
            return;
        } else if (lR == rR && lC == rC) {
            return;
        } else {
            while (cur1 <= rC - 1) {
                int temp = matrix[lR][cur1];
                matrix[lR][cur1] = matrix[cur4][lC];
                matrix[cur4][lC] = matrix[rR][cur3];
                matrix[rR][cur3] = matrix[cur2][rC];
                matrix[cur2][rC] = temp;
                cur1++;
                cur2++;
                cur3--;
                cur4--;
            }
        }
    }
}
