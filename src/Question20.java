import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Skye
 * @Date: 11:07 2018/4/13
 * @Description:
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * 思路一：每到一个位置，进行判断如何前进打印
 * 思路二：（剑指offer），循环打印一圈即可，判断边界条件  https://www.nowcoder.com/questionTerminal/9b4c81a02cd34f76be2659fa0d54342a
 */
public class Question20 {
    private static final int FLAG = Integer.MAX_VALUE;
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        int count = 0;
        int index1 = 0;
        int index2 = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int direction = 0;    // 0右移，1下移，2左移，3上移
        ArrayList<Integer> list = new ArrayList<>();
        while (count < m*n  ){
            list.add(matrix[index1][index2]);
            matrix[index1][index2] = FLAG;
            count++;
            if (count == m*n)
                break;
            int[] indexs = changIndex(matrix,index1,index2,direction);
            index1 = indexs[0];
            index2 = indexs[1];
            direction = indexs[2];
        }
        return list;
    }
    public static int[] changIndex(int [][] matrix,int index1,int index2,int direction){
        int m = matrix.length;
        int n = matrix[0].length;
        int[] indexs = new int[3];
        switch (direction){
            case 0: {
                if (index2 + 1 < n  && matrix[index1][index2+1] != FLAG) {
                    indexs[0] = index1;
                    indexs[1] = ++index2;
                    indexs[2] = 0;
                } else {
                    indexs[0] = ++index1;
                    indexs[1] = index2;
                    indexs[2] = 1;
                }
                break;
            }
            case 1:{
                if (index1 + 1 < m  && matrix[index1+1][index2] != FLAG) {
                    indexs[0] = ++index1;
                    indexs[1] = index2;
                    indexs[2] = 1;
                } else {
                    indexs[0] = index1;
                    indexs[1] = --index2;
                    indexs[2] = 2;
                }
                break;
            }
            case 2:{
                if (index2 - 1 >= 0 && matrix[index1][index2-1] != FLAG) {
                    indexs[0] = index1;
                    indexs[1] = --index2;
                    indexs[2] = 2;
                } else {
                    indexs[0] = --index1;
                    indexs[1] = index2;
                    indexs[2] = 3;
                }
                break;
            }
            case 3:{
                if (index1 - 1 >= 0 && matrix[index1-1][index2] != FLAG) {
                    indexs[0] = --index1;
                    indexs[1] = index2;
                    indexs[2] = 3;
                } else {
                    indexs[0] = index1;
                    indexs[1] = ++index2;
                    indexs[2] = 0;
                }
                break;
            }
        }
        return indexs;
    }

    public static void main(String[] args) {
        int [][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        List<Integer> list = printMatrix(matrix);
        System.out.println(list);
    }
}
