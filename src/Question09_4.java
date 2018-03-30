/**
 * @Author: Skye
 * @Date: 16:58 2018/3/18
 * @Description: 矩形覆盖
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class Question09_4 {
    public int RectCover(int target) {
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
