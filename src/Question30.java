import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: Skye
 * @Date: 11:06 2018/5/15
 * @Description: 最小的K个数
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class Question30 {
    // 方法一：partition 找第 k 大小的数的方法  O(n)，缺点是会修改输入的数组
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || input.length == 0 || input.length < k || k ==0 ){
            return result;
        }

        int length = input.length;
        int start = 0;
        int end = length -1;
        int index = partition(input,start,end);
        while (index != k-1 ){
            if (index > k-1){
                end = index - 1;
                index = partition(input,start,end);
            }else {
                start = index + 1;
                index = partition(input,start,end);
            }
        }
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }
    // 方法二：最大堆  O(nlogk)，适合海量数据的情况，数据量很大，不能一次性载入内存，可以放到辅助存储空间中
    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || input.length == 0 || input.length < k || k ==0 ){
            return result;
        }
        // java 优先级队列通过最小堆实现
        Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < input.length; i++) {
            if (i < k){
                heap.offer(input[i]);
            }else if (input[i] < heap.peek()){
                heap.poll();
                heap.offer(input[i]);
            }
        }
        result.addAll(heap);
        return result;
    }
    public int partition(int[] arr,int start,int end){
        int index = start + (int)(Math.random() * (end - start +1));
        swap(arr,index,end);
        int small = start - 1;
        for (index = start; index <= end; index++) {
            if (arr[index] < arr[end]){
                small++;
                swap(arr,small,index);
            }
        }
        small++;
        swap(arr,small,end);
        return small;
    }
    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,1,6,2,7,3,8};
        Question30 question30 = new Question30();
        System.out.println(question30.GetLeastNumbers_Solution2(arr,4));
    }
}
