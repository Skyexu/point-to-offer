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
 */
public class T1 {
    public static void main(String[] args) {
        boolean[][] matrix = new boolean[1001][1001];
        int rows = 1001;
        int cols = 1001;
        Scanner in = new Scanner(System.in);
        int starNum = in.nextInt();
        for (int i = 0; i < starNum; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
           // matrix[x*rows+y] = true;
            matrix[x][y] = true;
        }
        int questionNum = in.nextInt();
        for (int i = 0; i < questionNum; i++) {
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            int start = x1*rows+y1;
            int end = x2*rows+y2;
            int count = 0;
//            for (int j = start; j <=end ; j++) {
//                if (matrix[j]){
//                    count++;
//                }
//            }
            for (int j = x1; j <= x2; j++) {
                for (int k = y1; k <=y2 ; k++) {
                    if (matrix[j][k]){
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

}
