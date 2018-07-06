package learn;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * @Author: Skye
 * @Date: 15:38 2018/6/21
 * @Description: 小和问题，归并排序应用
 * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组的小和
 */
public class Code_04_SmallSum {
    public static int small_sum(int[] arr){
        if (arr == null || arr.length < 2)
            return 0;
        return mergeSort(arr,0,arr.length-1);
    }
    public static int mergeSort(int[] arr,int start,int end){
        if (start >= end)
            return 0;
        int[] temp = new int[end - start + 1];
        int mid = (end+start)/2;
        int sum0 = mergeSort(arr,start,mid);
        int sum1 = mergeSort(arr,mid+1,end);
        int p1 = start;
        int p2 = mid + 1;
        int i = 0;
        int sum2 = 0;
        while (p1 <= mid && p2 <= end){
            sum2 += arr[p1] < arr[p2]? (end - p2 + 1)* arr[p1] : 0;
            temp[i++] = arr[p1] < arr[p2]? arr[p1++]:arr[p2++];
        }
        while (p1 <= mid){
            temp[i++] = arr[p1++];
        }
        while (p2 <= end){
            temp[i++] = arr[p2++];
        }
        for (int j = 0; j < temp.length; j++) {
            arr[start+j] = temp[j];
        }
        return sum0 + sum1 + sum2;
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // for test, java 默认实现，一个保证对的方法
    public static int comparator(int[] arr){
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                res += arr[j] < arr[i] ? arr[j] : 0;
            }
        }
        return res;
    }

    // for test, 产生一个随机数组
    public static int[] generateRandomArray(int maxSize,int maxValue){
        // random array size
        int[] arr = new int[(int)((1 + maxSize) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }

        return arr;
    }
    //for test
    public static int[] copyArray(int[] arr){
        if (arr == null)
            return null;
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }
    //for test
    public static boolean isEqual(int[] arr1,int[] arr2){
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // 与保证正确的答案对比多次，验证结果
        int testTime = 50000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize,maxValue);
            int[] arr2 = copyArray(arr1);
            int s1 = small_sum(arr1);
            int s2 = comparator(arr2);
            if (s2!=s1){
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!":"Fucking!");



    }
}
