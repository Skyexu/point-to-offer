package examination.sixtest;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Author: Skye
 * @Date: 20:11 2018/6/14
 * @Description: 牛牛与世界杯门票   (0,1) 背包 动态规划
 *  题目描述
今年的世界杯要开始啦，牛牛作为一个球迷，当然不会放过去开幕式现场的机会。但是牛牛一个人去又觉得太过寂寞，
便想叫上了他的n个小伙伴陪他一起去莫斯科(一共n+1人)。当牛牛开始订开幕式的门票时，发现门票有m种套餐，
每种套餐需要花费x元，包含y张门票，每张门票也可以单独购买，此时这张门票的价格为k元。
请问牛牛要怎样选择购买门票，使得他花费的钱最少。(每种套餐可以购买次数没有限制)。
输入描述:
第一行输入三个数字n(0≤n≤999)、m(1≤m≤1000)和k(1≤k≤100000)
接下来m行，每行输入两个数字xi(1≤xi≤100000)和yi(2≤yi≤1000), 表示套餐的价格和套餐内包含的门票数量。
输出描述:
输出牛牛至少要花费的钱的数量。
https://www.nowcoder.com/discuss/84527
 解法：动态规划，完全背包。  将 n+1 看作背包容量，套餐门票价格相当于价值，门票张数是费用
 */
public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int personNum = in.nextInt() + 1;
        int m = in.nextInt();
        int k = in.nextInt();

        int[] dp = new int[personNum+1];
        for (int i = 1; i <= personNum; i++) {
            dp[i] = i * k;
        }
        for (int i = 0; i < m; i++) {
            int money = in.nextInt();
            int ticketNum = in.nextInt();

            for (int j = 1; j <= personNum; j++) {
                if (j - ticketNum < 0){
                    dp[j] = Math.min(dp[j],money);
                }else {
                    dp[j] = Math.min(dp[j],dp[j-ticketNum] + money);
                }
            }
        }

        System.out.println(dp[personNum]);
    }


}
