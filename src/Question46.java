import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Skye
 * @Date: 11:46 2018/5/29
 * @Description: 扑克牌顺子
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何。为了方便起见,你可以认为大小王是0。
 */
public class Question46 {
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length < 2){
            return false;
        }
        int len = numbers.length;
        Set<Integer> selectNum = new HashSet<>();
        int[] seNums = new int[5];
        while (selectNum.size() < 5){
            int random = (int)Math.random()*len;
            selectNum.add(random);
        }
        int index =0;
        for (Integer num:
             selectNum) {
            seNums[index++] = numbers[num];
        }
        Arrays.sort(seNums);

        int numZero = 0;
        int gap = 0;
        
    }
}
