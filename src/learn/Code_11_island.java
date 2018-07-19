package learn;

/**
 * @Author: Skye
 * @Date: 13:30 2018/7/19
 * @Description: 岛问题
 * 一个矩阵中只有0和1两种值，每个位置都可以和自己的上、下、左、右
四个位置相连，如果有一片1连在一起，这个部分叫做一个岛，求一个
矩阵中有多少个岛？
举例：
0 0 1 0 1 0
1 1 1 0 1 0
1 0 0 1 0 0
0 0 0 0 0 0
这个矩阵中有三个岛。
 */
public class Code_11_island {
    public static int countIslands(int[][] matrix){
        if(matrix == null)
            return 0;
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1){
                    res++;
                    dfs(matrix,i,j);
                }
            }
        }
        return res;
    }
    public static void dfs(int[][] matrix,int i,int j){
        if (i < 0||i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] != 1){
            return;
        }
        matrix[i][j] = 2;
        dfs(matrix,i,j+1);
        dfs(matrix,i,j-1);
        dfs(matrix,i-1,j);
        dfs(matrix,i+1,j);
    }
    public static void main(String[] args) {
        int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(countIslands(m1));

        int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(countIslands(m2));

    }
}
