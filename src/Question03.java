/**
 * @Author: Skye
 * @Date: 19:28 2017/10/17
 * @Description:
 * 题目描述:
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 解法：由于这个矩阵的性质，分别向右向下递增，那么从左下开始查找，如果当前数值小于目标值，则当前列都比目标值小，不考虑当前列 col++ ；
 * 反之，如果当前数值大于目标值，则当前行都比目标值大，不考虑当前行 row --；直到找到目标值或者出边界
 */
public class Question03 {
    public static boolean find(int target, int [][] array) {
        // 输入条件判断
        if (array == null || array.length < 1|| array[0].length < 1)
            return false;
        int row = array.length -1;
        int col = 0;
        while (col <= array[0].length - 1 && row >= 0) {
            if (array[row][col] < target)
                col ++;
            else if (array[row][col] > target)
                row --;
            else
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(find(7,matrix));
    }
}
