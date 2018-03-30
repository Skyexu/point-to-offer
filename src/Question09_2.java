/**
 * @Author: Skye
 * @Date: 18:24 2018/3/17
 * @Description: 跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 *  解法：跳1级是1，2级是2，n > 2 时，有两种情况，先跳 1 级，那么接下来有 f(n-1) 种跳法，先跳 2 级，有 f(n-2) 种跳法，这就是个斐波那契数列。
 */
public class Question09_2 {
    public int JumpFloor(int target) {
        switch (target){
            case 0:return 0;
            case 1:return 1;
            case 2:return 2;
        }

        int pre1 = 1;
        int pre2 = 2;
        int result = 3;
        for (int i = 3; i <= target; i++) {
            result = pre1 + pre2;
            pre1 = pre2;
            pre2 = result;
        }
        return result;
    }
}
