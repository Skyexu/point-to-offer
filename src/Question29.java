import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Skye
 * @Date: 20:40 2018/5/14
 * @Description: 数组中出现次数超过一半的数字   (时间效率)
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字 2 在数组中出现了5 次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Question29 {
    // 1.借助 hashMap 实现，时间复杂度高
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array.length == 0)
            return 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < array.length;i++){
            if (map.containsKey(array[i])){
                map.put(array[i],map.get(array[i])+1);
                if (map.get(array[i]) > array.length / 2){
                    return array[i];
                }
            }else {
                map.put(array[i],1);
                if (1 > array.length / 2)
                    return array[i];
            }
        }
        return 0;
    }
    // 基于快排 partition 的思路，次数字若存在，则一定是中位数，如果 index > middle 则中位数在 index 左边
    public int MoreThanHalfNum_Solution2(int [] array) {
        if (array == null || array.length == 0){
            return 0;
        }
        int length = array.length;
        int middle = length/2;
        int start = 0;
        int end = length -1;
        int index = partition(array,start,end);
        while (index != middle ){
            if (index > middle){
                end = index - 1;
                index = partition(array,start,end);
            }else {
                start = index + 1;
                index = partition(array,start,end);
            }
        }
        // 判断结果是否正确
        int count = 0;
        int value = array[index];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value)
                count++;
        }
        if (count * 2 > length){
            return value;
        }
        return 0;
    }
    // 3.根据数组特点来解，如果有符合条件的数字，则它出现的次数比其他所有数字出现的次数和还要多。
    //在遍历数组时保存两个值：一是数组中一个数字，一是次数。遍历下一个数字时，若它与之前保存的数字相同，则次数加1，否则次数减1；
    //若次数为0，则保存下一个数字，并将次数置为1。遍历结束后，所保存的数字即为所求。然后再判断它是否符合条件即可。
    public int MoreThanHalfNum_Solution3(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int result = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (count == 0){
                result = array[i];
                count = 1;
            }else if (array[i] == result){
                count++;
            }else {
                count--;
            }
        }
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == result)
                count++;
        }
        if (count * 2 > array.length){
            return result;
        }
        return 0;
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
        int[] arr = new int[]{1,2,3,2,4,2,5,2,3};
        Question29 question29 = new Question29();
        System.out.println(question29.MoreThanHalfNum_Solution3(arr));
    }
}
