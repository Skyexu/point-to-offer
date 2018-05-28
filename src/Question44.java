import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Skye
 * @Date: 14:46 2018/5/28
 * @Description: 左旋转字符串
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 是不是很简单？OK，搞定它！
 */
public class Question44 {
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() ==0 || n < 0){
            return str;
        }
        Queue<Character> queue1 = new LinkedList<>();
        Queue<Character> queue2 = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            queue1.offer(str.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            queue1.offer(queue1.poll());
        }
        char[] res = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            res[i] = queue1.poll();
        }
        return String.copyValueOf(res);
    }
//    链接：https://www.nowcoder.com/questionTerminal/12d959b108cb42b1ab72cef4d36af5ec
//    来源：牛客网
//
//    public String LeftRotateString(String str, int n) {
//        char[] chars = str.toCharArray();
//        if (chars.length < n) {
//            return "";
//        }
//        reverse(chars, 0, n - 1);
//        reverse(chars, n, chars.length - 1);
//        reverse(chars, 0, chars.length - 1);
// 
//        return new String(chars);
//    }
// 
//            public void reverse(char[] chars, int start, int end) {
//        while (start < end) {
//            char temp = chars[start];
//            chars[start] = chars[end];
//            chars[end] = temp;
//            start++;
//            end--;
//        }
//    }
    public static void main(String[] args) {
        Question44 question44 = new Question44();
        String test = "abcXYZdef";
        System.out.println(question44.LeftRotateString(test,3));
    }
}
