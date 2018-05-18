/**
 * @Author: Skye
 * @Date: 16:47 2018/5/17
 * @Description: 连续子数组的最大和
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,
 * 常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,
 * 并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class Question31 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0 ){
            return 0;
        }
        int D[] = new int[array.length];
        D[0] = array[0];
        int max = D[0];
        for (int i = 1; i < array.length; i++) {
            if (D[i-1] < 0){   // 当前面的值是负数，当前值与负数相加比本身还小，其实类似于计算 f(i-1) + array[i] 和 array[i] 自身比较
                D[i] = array[i];
            }else {
                D[i] = D[i-1] + array[i];
            }
            if (D[i] > max){
                max = D[i];
            }
        }
        return max;
    }
}
