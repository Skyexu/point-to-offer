import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Skye
 * @Date: 9:36 2018/5/19
 * @Description: 丑数
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class Question34 {
    // 方法一：超时
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0){
            return 0;
        }
        int uglyNumber = 0;

        for (int i = 1; ; i++) {
            if (index == 0)
                break;
            if (isUglyNumber(i)){
                index--;
                uglyNumber = i;
            }
        }
        return uglyNumber;
    }
    public boolean isUglyNumber(int num) {
        while (num %2 ==0){
            num /= 2;
        }
        while (num %3 ==0){
            num /= 3;
        }
        while (num %5 ==0){
            num /= 5;
        }
        return num == 1;
    }
    // 方法二：按顺序保存丑数
    public int GetUglyNumber_Solution2(int index) {
        if (index <= 0){
            return 0;
        }
        List<Integer> uglyList = new ArrayList<>();
        uglyList.add(1);
        int index2 = 0,index3 = 0,index5 = 0;
        while (uglyList.size() < index){
            int num2 = uglyList.get(index2) * 2 ;
            int num3 = uglyList.get(index3) * 3;
            int num5 = uglyList.get(index5) * 5;
            int min = Math.min(num2,Math.min(num3,num5));
            if (min == num2) index2++;
            if (min == num3) index3++;
            if (min == num5) index5++;

            uglyList.add(min);
        }
        return uglyList.get(uglyList.size()-1);
    }
    public static void main(String[] args) {
        Question34 question34 = new Question34();
        System.out.println(question34.GetUglyNumber_Solution2(2));
    }
}
