import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: Skye
 * @Date: 9:35 2018/5/3
 * @Description: 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */
public class Question22 {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length != popA.length)
            return false;
        if (pushA.length == 1 ){
            if (pushA[0] == popA[0])
                return true;
            else
                return false;
        }

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < pushA.length; i++) {
            map.put(pushA[i],i);
        }
        int[] indexArr  = new int[popA.length];
        for (int i = 0; i < popA.length; i++) {
            indexArr[i] = map.get(popA[i]);
        }
        // 判断出栈顺序是否合理
        int now = indexArr[0];
        for (int i = 1; i < indexArr.length; i++) {
            if (indexArr[i] > indexArr[i-1] && indexArr[i] < now)
                return false;
        }
        return true;
    }
    // 修改后，借助辅助栈来解题
    public static boolean IsPopOrder2(int [] pushA,int [] popA) {
        if (pushA.length != popA.length || pushA.length == 0 || popA.length == 0)
            return false;
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            // 判断栈顶是否和出栈序列位置相等，相等则弹出，继续判断
            while (!stack.isEmpty() && stack.peek() == popA[popIndex]){
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        int[] push = new int[]{1,2,3,4,5};
        int[] pop = new int[]{4,5,3,2,1};
        System.out.println(IsPopOrder2(push,pop));
    }
}
