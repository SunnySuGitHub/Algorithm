package Class_7;

/**
 * Description:岛问题
 * 一个矩阵中只有0和1两种值，每个位置都可以和自己的上下左右四个位置相连，
 * 如果有一片1连在一起，这个部分叫做一个岛，求一个矩阵中有多少个岛
 * 举例：
 * 0 0 1 0 1 0
 * 1 1 1 0 1 0
 * 1 0 0 1 0 0
 * 0 0 0 0 0 0
 * 这个矩阵中有三个岛010226
 * Created by Administrator on 2019/1/21
 */
public class ProblemisLand {
    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 1, 0, 1, 0},
                {1, 1, 1, 0, 1, 0},
                {1, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 0}
    };
        System.out.println(countIsLands(matrix));
    }

    public static int countIsLands(int[][] m){
        if(m == null || m[0] == null){
            return 0;
        }
        int N = m.length;//行数
        int M = m[0].length;//列数
        int res = 0;
        for(int i = 0; i < N; i++){//从第一行开始
            for(int j = 0; j < M; j++){//每一行从第一列开始
                if(m[i][j] == 1){//碰到是1的开始感染
                    res++;
                    infect(m, i, j, N, M);
                }
            }
        }
        return res;
    }

    public static void infect(int[][] m, int i, int j, int N, int M){
        if(i < 0 || i >= N || j < 0 || j >= M || m[i][j] != 1){
            return;
        }
        m[i][j] = 2;
        infect(m, i + 1, j, N, M);
        infect(m, i - 1, j, N, M);
        infect(m, i, j + 1, N, M);
        infect(m, i, j - 1, N, M);
    }
}
