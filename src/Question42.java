import java.util.ArrayList;

/**
 * @Author: Skye
 * @Date: 16:50 2018/5/25
 * @Description: 和为S的连续正数序列
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 */
public class Question42 {
    // 使用两个指针一直移动，初始small 1，big 2 ，如果和小于 sum 则 big++ , 如果和大于 sum 则 small--
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
        if (sum <= 2){
            return resList;
        }
        int small = 1;
        int big = 2;
        int sumNow = 3;
        while (small < (sum+1)/2){
            if (sumNow < sum){
                big++;
                sumNow += big;
            }else if (sumNow > sum){
                sumNow -= small;
                small++;
            }else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = small;i <= big;i++){
                    list.add(i);
                }
                resList.add(list);
                big ++;
                sumNow += big;
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        Question42 question42 = new Question42();
        System.out.println(question42.FindContinuousSequence(9));
    }
}
