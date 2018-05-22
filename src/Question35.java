/**
 * @Author: Skye
 * @Date: 10:17 2018/5/19
 * @Description: 第一个只出现一次的字符
 *
 *  在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */
public class Question35 {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() < 1 )
            return -1;
        int[] counts = new int[128];
        for (int i = 0; i < str.length(); i++) {
            counts[str.charAt(i)-'A']++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (counts[str.charAt(i) - 'A']==1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Question35 question35 = new Question35();
        System.out.println(question35.FirstNotRepeatingChar("NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp"));
    }
}
