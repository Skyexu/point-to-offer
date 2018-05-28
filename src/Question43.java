import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Skye
 * @Date: 14:15 2018/5/28
 * @Description: 和为S的两个数字
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class Question43 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> resList = new ArrayList<>();
        if (array == null || array.length == 0 || sum < 0){
            return resList;
        }
        int multMin = Integer.MAX_VALUE;
        int small = 0;
        int big = array.length-1;

        while (small < big){
            int sumNow = array[small] + array[big];
            if (sumNow > sum){
                big--;
            }else if (sumNow < sum){
                small++;
            }else {
                if (array[small] * array[big] < multMin){
                    resList = new ArrayList<>(Arrays.asList(new Integer[]{array[small],array[big]}));
                    multMin = array[small] * array[big];
                }
                big--;
            }

        }
        return resList;
    }

    public static void main(String[] args) {
        Question43 question43 = new Question43();
        int[] arr = new int[]{1,4,6,7,8,9};
        System.out.println(question43.FindNumbersWithSum(arr,15));
    }
}
