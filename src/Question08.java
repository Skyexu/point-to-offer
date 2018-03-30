/**
 * @Author: Skye
 * @Date: 10:47 2018/3/17
 * @Description:  旋转数组的最小数字
 * 题目描述
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 1.包含两个有序序列
 * 2.最小数一定位于第二个序列的开头
 * 3.前序列的值都>=后序列的值
 */
public class Question08 {
    public int minNumberInRotateArray(int [] array) {
        int arrSize = array.length;
        if (arrSize == 0){
            return 0;
        }

        int first = array[0];
        int min = 0 ;
        for (int i = 0; i < arrSize; i++) {
            if (array[i] >= first){
                first = array[i];
            }else {
                min = array[i];
                break;
            }

        }
        return min;
    }

    /**
     * 二分查找
     * @param array
     * @return
     */
    public int minNumberInRotateArray2(int [] array) {
        int arrSize = array.length;
        if (arrSize == 0){
            return 0;
        }

        int index1 = 0;
        int index2 = arrSize-1;
        int mid = 0 ;
        while (array[index1] >= array[index2]) {
            if (index2 - index1 == 1){
                mid = index2;
                break;
            }
            mid = (index1 + index2)/2;
            if (array[mid] >= array[index1]){
                index1 = mid;
            }else if (array[mid] <= array[index2]){
                index2 = mid;
            }

        }
        return array[mid];
    }

}
