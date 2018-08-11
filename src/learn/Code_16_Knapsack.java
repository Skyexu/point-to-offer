package learn;

/**
 * @Author: Skye
 * @Date: 17:38 2018/8/2
 * @Description:
 */
public class Code_16_Knapsack {
    public static int knapsack(int[] weights,int[] values,int bag,int i,int sumValue,int alreadyWeight){
        if (i == weights.length || alreadyWeight + weights[i] > bag){
            return sumValue;
        }

        return Math.max(knapsack(weights,values,bag,i+1,sumValue,alreadyWeight),
                knapsack(weights,values,bag,i+1,sumValue+values[i],alreadyWeight+weights[i]));
    }
    public static int knapsack2(int[] weights,int[] values,int bag){
        int[][] dp = new int[weights.length][bag+1];
        // 初始化 第一个物品 的时候
        for (int i = 0; i < bag + 1; i++) {
            if (weights[0] <= bag)
                dp[0][i] = values[0];
        }

        for (int i = 1; i < weights.length ; i++) {
            for (int j = 0; j < bag + 1; j++) {
                if (j - weights[i] >= 0 ){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weights[i]] + values[i]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[weights.length-1][bag];
    }

    /**
     * @param m 表示背包的最大容量
     * @param n 表示商品个数
     * @param w 表示商品重量数组
     * @param p 表示商品价值数组
     */
    public static int[][] BackPack_Solution(int m, int n, int[] w, int[] p) {
        //c[i][v]表示前i件物品恰放入一个重量为m的背包可以获得的最大价值
        int c[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++)
            c[i][0] = 0;
        for (int j = 0; j < m + 1; j++)
            c[0][j] = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                //当物品为i件重量为j时，如果第i件的重量(w[i-1])小于重量j时，c[i][j]为下列两种情况之一：
                //(1)物品i不放入背包中，所以c[i][j]为c[i-1][j]的值
                //(2)物品i放入背包中，则背包剩余重量为j-w[i-1],所以c[i][j]为c[i-1][j-w[i-1]]的值加上当前物品i的价值
                if (w[i - 1] <= j) {
                    if (c[i - 1][j] < (c[i - 1][j - w[i - 1]] + p[i - 1]))
                        c[i][j] = c[i - 1][j - w[i - 1]] + p[i - 1];
                    else
                        c[i][j] = c[i - 1][j];
                } else
                    c[i][j] = c[i - 1][j];
            }
        }
        return c;
    }
    public static void main(String[] args) {
        int[] c = { 3, 2, 4, 7 };
        int[] p = { 5, 6, 3, 19 };
        int bag = 11;
        System.out.println(knapsack(c, p, bag,0,0,0));
        System.out.println(knapsack2(c, p, bag));
    }
}
