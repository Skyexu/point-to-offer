/**
 * @Author: Skye
 * @Date: 20:46 2018/3/26
 * @Description: 数值的整数次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方
 */
public class Question11 {
    /**
     * 优化求幂函数
     *当n为偶数，a^n =（a^n/2）*（a^n/2）
     *当n为奇数，a^n = a^[(n-1)/2] * a^[(n-1)/2] * a
     *时间复杂度O(logn)
     *
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        int n = Math.abs(exponent);
        double result = 0.0;
        if (n == 0)
            return 1.0;
        if (n == 1)
            return base;

        result = Power(base, n >> 1);
        result *= result;
        if ((n & 1) == 1) // 如果指数n为奇数，则要再乘一次底数base
            result *= base;
        if (exponent < 0) // 如果指数为负数，则应该求result的倒数
            result = 1 / result;

        return result;

    }
}
