import java.io.FileWriter;

/**
 * @Author: Skye
 * @Date: 16:54 2018/3/17
 * @Description: 斐波那契数列
 * 题目描述
大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
n<=39
 */
public class Question09_1 {

    /**
     * 递归效率低，会有很多重复计算
     * @param n
     * @return
     */
    public int Fibonacci(int n) {

        if (n == 0){
            return 0;
        }else if (n ==1){
            return 1;
        }
        return Fibonacci(n-1)+ Fibonacci(n-2);
    }

    /**
     * 非递归，使用循环
     * @param n
     * @return
     */
    public int Fibonacci2(int n) {

        if (n == 0){
            return 0;
        }else if (n ==1){
            return 1;
        }
        int pre1 = 0;
        int pre2 = 1;
        int temp = 0;
        for (int i = 2; i <= n; i++) {
            temp = pre1 + pre2;
            pre1 = pre2;
            pre2 = temp;
        }

        return temp;
    }
}
