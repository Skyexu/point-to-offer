package learn;

import java.util.Arrays;

/**
 * @Author: Skye
 * @Date: 16:52 2018/8/2
 * @Description: 给你一个数组arr，和一个整数aim。如果可以任意选择arr中的数字，能不能累加得到aim，返回true或者false
 */
public class Code_15_Money_Problem {
    /**
     * 递归尝试，一个数字有选和不选两种可能
     * @param arr  数组
     * @param i    当前处理的位置
     * @param sum  当前和
     * @param aim  目标和
     * @return
     */
    public static boolean isSum1(int[] arr,int i ,int sum, int aim){
        // 所有数字都考虑完成后，判断是否能够累加得到 aim
        if (i == arr.length){
            return sum == aim;
        }

        return isSum1(arr,i+1,sum,aim) || isSum1(arr,i+1,sum+arr[i],aim);
    }

    /**
     * 动态规划版本，先确定 DP 范围，构造 DP ，再确定 base case，再思考普遍位置的情况
     * @param arr
     * @param aim
     * @return
     */
    public static boolean isSum2(int[] arr,int aim){
        int sum = Arrays.stream(arr).sum();
        boolean[][] dp = new boolean[arr.length + 1][sum + 1];
        // base case
        dp[arr.length][sum] = true;
        for (int i = 0; i <= sum; i++) {
            if (i == aim){
                dp[arr.length][i] = true;
            }else {
                dp[arr.length][i] = false;
            }
        }

        // 普遍情况
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j <= sum ; j++) {
                if (j + arr[i] <= sum){
                    dp[i][j] = dp[i+1][j] || dp[i+1][j+arr[i]];
                }else {
                    dp[i][j] = dp[i+1][j];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 8 };
        int aim = 12;
        System.out.println(isSum1(arr, 0,0, aim));
        System.out.println(isSum2(arr, aim));
    }
}
