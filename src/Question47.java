import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Skye
 * @Date: 18:42 2018/5/29
 * @Description: 孩子们的游戏(圆圈中最后剩下的数)
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
 * HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。
 * 然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,
 * 并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 */
public class Question47 {
    // 方法一： 使用 List 模拟圆圈结构，每次从列表中删除一个元素
    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0 || m <= 0){
            return -1;
        }
        List<Integer> circle = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            circle.add(i);
        }
        int cur = 0;
        while (circle.size() > 1){
            for (int i = 1; i < m; i++) {
                cur++;
                if (cur == circle.size()){
                    cur = 0;
                }
            }

            if (cur == circle.size() - 1){
                circle.remove(cur);
                cur = 0;
            }else {
                circle.remove(cur);
            }

        }
        return circle.get(0);
    }

    public static void main(String[] args) {
        Question47 question47 = new Question47();
        System.out.println(question47.LastRemaining_Solution(5,3));
    }
}
