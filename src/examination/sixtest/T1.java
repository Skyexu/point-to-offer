package examination.sixtest;

import java.util.Scanner;

/**
 * @Author: Skye
 * @Date: 19:39 2018/6/14
 * @Description:  牛牛数星星
 * 一闪一闪亮晶晶，满天都是小星星，牛牛晚上闲来无聊，便躺在床上数星星。
牛牛把星星图看成一个平面，左上角为原点(坐标为(1, 1))。现在有n颗星星，他给每颗星星都标上坐标(xi，yi)，
表示这颗星星在第x行，第y列。
现在，牛牛想问你m个问题，给你两个点的坐标(a1, b1)(a2，b2)，
表示一个矩形的左上角的点坐标和右下角的点坐标，请问在这个矩形内有多少颗星星（边界上的点也算是矩形内）。
输入描述:
第一行输入一个数字n(1≤n≤100000)，表示星星的颗数。
接下来的n行，每行输入两个数xi和yi(1≤xi，yi≤1000），表示星星的位置。
然后输入一个数字m(1≤m≤100000), 表示牛牛询问问题的个数。
接下来m行，每行输入四个数字a1，b1，a2，b2(1≤a1＜a2≤1000), (1≤b1＜b2≤1000）
题目保证两颗星星不会存在于同一个位置。
输出描述:
输出一共包含m行，每行表示与之对应的每个问题的答案。

解法：   10000*10000规模的星星矩阵，每次查询都遍历所有的话肯定会超时。
        可以先计算出每个个点左上方一共有多少颗星星，记为 num 矩阵。
        查询某个矩形中的星星数，(x1, y1)(x2，y2)  即为 num[x2][y2] - num[x2][y1-1] - num[x1-1][y2] + num[x1-1][y1-1]
        这样每次查询为O(1)
        计算出每个个点左上方一共有多少颗星星，可以累加
https://www.nowcoder.com/discuss/84527
 */
public class T1 {
    public static void main(String[] args) {
        int[][] matrix = new int[1005][1005];
        int[][] num = new int[1005][1005];
        Scanner in = new Scanner(System.in);
        int starNum = in.nextInt();
        int x,y;
        for (int i = 0; i < starNum; i++) {
            x = in.nextInt();
            y = in.nextInt();
           // matrix[x*rows+y] = true;
            matrix[x][y] = 1;
        }

        // 计算 num
        for (int i = 1; i < 1005; i++) {
            for (int j = 1; j < 1005; j++) {
                num[i][j] = num[i][j-1] + num[i-1][j] - num[i-1][j-1] + matrix[i][j];
            }
        }
        int questionNum = in.nextInt();
        int x1,y1,x2,y2;
        for (int i = 0; i < questionNum; i++) {
            x1 = in.nextInt();
            y1 = in.nextInt();
            x2 = in.nextInt();
            y2 = in.nextInt();
            System.out.println( num[x2][y2] - num[x2][y1-1] - num[x1-1][y2] + num[x1-1][y1-1]);
        }
    }

}
