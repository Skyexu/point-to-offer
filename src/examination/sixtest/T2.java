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
 */
public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int personNum = in.nextInt() + 1;
        int m = in.nextInt();
        int k = in.nextInt();
        int[][] mType = new int[m+1][2];
        for (int i = 0; i < m; i++) {
            int money = in.nextInt();
            int ticketNum = in.nextInt();
            mType[i][0] = money;
            mType[i][1] = ticketNum;
        }
        mType[m][0] = k;
        mType[m][1] = 1;
        System.out.println(getMoney(personNum,m,mType));
    }

    private static int getMoney(int personNum,int m,int[][] mType){
        // 计算票价与票数比例，并按比例从低到高排序
        // map 存放mType 索引与对应的比例值
        Map<Double,Integer> rankMap = new TreeMap<>();
        for (int i = 0; i < m + 1; i++) {
            rankMap.put(mType[i][0]*1.0/mType[i][1],i);
        }
        int totalMoney = 0;
        for (Map.Entry<Double,Integer> map:rankMap.entrySet()){
            if (personNum == 0)
                break;
            int index = map.getValue();
            int num = mType[index][1];
            if (personNum >= num){
                int a = personNum / num;
                personNum = personNum % num;
                totalMoney += a * mType[index][0];
            }
        }

        return totalMoney;
    }
}
