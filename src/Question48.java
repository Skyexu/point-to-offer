/**
 * @Author: Skye
 * @Date: 15:01 2018/5/30
 * @Description: 求1+2+3+...+n
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Question48 {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean flag = (sum > 0) && ((sum += Sum_Solution(n-1)) > 0);
        return sum;
    }
}
