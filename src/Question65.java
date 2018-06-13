import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * @Author: Skye
 * @Date: 14:56 2018/6/13
 * @Description: 滑动窗口的最大值
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，{2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class Question65 {

    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> maxValues = new ArrayList<>();
        if (num == null || num.length ==0 || size <= 0 || size > num.length){
            return maxValues;
        }
        int first = 0;
        int second = size -1;
        boolean isFirst = true;
        int maxNow = 0;
        int maxIndex = 0;
        while (second < num.length ){

            // 如果上次比较的最大值在 first 位置，则这次需要获取当前 first 到 Second 的最大值
            if (isFirst){
                maxIndex = getMax(num,first,second);
                maxNow = num[maxIndex];
                maxValues.add(maxNow);
            }else {
                // 如果最大值不在 first 位置，则比较之前的最大值和当前 second
                if (maxNow < num[second]){
                    maxNow = num[second];
                    maxIndex = second;
                }
                maxValues.add(maxNow);
            }
            if (maxIndex == first){
                isFirst = true;
            }else {
                isFirst = false;
            }
            first++;
            second++;
        }
        return maxValues;
    }
    private int getMax(int[] num,int first,int second){
        int max = Integer.MIN_VALUE;
        int index = first;
        for (int i = first; i <= second; i++) {
            if (num[i] > max){
                max = num[i];
                index = i;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        Question65 question65 = new Question65();
        int[] num = new int[]{2,3,4,2,6,2,5,1};
        ArrayList<Integer> list = question65.maxInWindows(num,3);
        System.out.println(list);
    }
}
