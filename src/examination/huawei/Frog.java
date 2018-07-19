package examination.huawei;

import java.util.Scanner;

/**
 * @Author: Skye
 * @Date: 19:17 2018/7/18
 * @Description: 青蛙跳桥，桥中有石子
 * http://www.cnblogs.com/kuangbin/archive/2012/02/27/2369901.html  题目
 */
public class Frog {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int min = in.nextInt();
        int max = in.nextInt();
        //dp[i] 表示到 i ，最少的石子数
        int[] dp = new int[L+max];
        for (int i = 0; i < L+max; i++) {
            dp[i] = -1;
        }
        int[] flag = new int[L+max];

        int stoneNum = in.nextInt();
        for (int i = 0; i < stoneNum; i++) {
            int n = in.nextInt();
            flag[n] = 1;
        }
        dp[0] = 0;
        for (int i = min; i <= L + max -1 ; i++) {      // 遍历能跳到的地方
            for (int j = i - max; j <= i - min; j++) {    // 从 j 跳到 i，只能由 i - max 到 i - min 跳过来
                if (j >= 0 && dp[j] != -1 ){
                    if (dp[i] == -1){
                        dp[i] = dp[j] + flag[i];
                    }else if (dp[i] > dp[j] + flag[i]){
                        dp[i] = dp[j] + flag[i];
                    }
                }
            }
        }
        int res = 10000;
        for (int i = 0; i < L + max; i++) {
            if(dp[i] != -1 && dp[i] < res){
                res = dp[i];
            }
        }
        System.out.println(res);
    }
}
