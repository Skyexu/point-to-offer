package learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Skye
 * @Date: 14:58 2018/7/7
 * @Description: 给定一个数组，求排序之后，相邻两数的最大差值，要求时间复杂度O(N)，且要求不能用非基于比较的排序
 */
public class Code_08_MaxGap {
    public static int maxGap(int[] nums){
        if (nums == null || nums.length < 2){
            return 0;
        }
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
        }
        if (max == min){
            return 0;
        }
        // 创建 n + 1 个桶
        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        // 桶标记
        int index = 0;
        for (int i = 0; i < len; i++) {
            index = bucket(nums[i],len,min,max);
            mins[index] = hasNum[index] ? Math.min(nums[i],mins[index]) : nums[i];
            maxs[index] = hasNum[index] ? Math.max(nums[i],maxs[index]) : nums[i];
            hasNum[index] = true;
        }

        int res = 0;
        int lastMax = maxs[0];
        for (int i = 1; i <= len; i++) {
            if (hasNum[i]){
                res = Math.max(res,mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    /**
     * 返回当前数属于哪个桶
     * @param num
     * @param len
     * @param min
     * @param max
     * @return
     */
    public static int bucket(int num,int len,int min,int max){
        return (num - min) * len / (max - min);
    }

    // for test
    public static int comparator(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int gap = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            gap = Math.max(nums[i] - nums[i - 1], gap);
        }
        return gap;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static void main(String[] args) {
        int testTime = 5000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (maxGap(arr1) != comparator(arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

    }
}
