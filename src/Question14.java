import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Skye
 * @Date: 19:37 2018/3/30
 * @Description: 调整数组顺序使奇数位于偶数前面
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。

 考察代码的完整性
 */
public class Question14 {
    public static void reOrderArray(int [] array) {
        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();
        if (array.length == 1 || array.length == 0){
            return;
        }
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] % 2 == 0&& i+1 < array.length){
//                for (int j = i+1; j < array.length; j++) {
//                    if (array[j] % 2 == 1){
//                        int temp = array[i];
//                        array[i] = array[j];
//                        array[j] = temp;
//                    }
//                }
//            }
//        }
        for (int i = 0; i <array.length ; i++) {
            if (array[i] % 2 == 0){
                evenList.add(array[i]);
            }else {
                oddList.add(array[i]);
            }
        }
        int index = 0;
        for (int i = 0; i < oddList.size(); i++) {
            if (index < array.length)
                array[index++] = oddList.get(i);
        }
        for (int i = 0; i < evenList.size(); i++) {
            if (index < array.length)
                array[index++] = evenList.get(i);
        }
    }

    public static void main(String[] args) {
        int[] test =  {1,2,6,3,7,2,85,84};
        reOrderArray(test);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }
}
