/**
 * @Author: Skye
 * @Date: 8:58 2017/10/19
 * @Description:
 * 题目描述
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * 本题在 java 里没有多大意义，要求不新建字符串数组来做。StringBuffer 实现变长字符串
 */
public class Question04 {
    public static String replaceSpace2(StringBuffer str) {
        int oldLength = str.length();
        int numSpace = 0;
        for(int i = 0;i < str.length();i++){
            if (str.charAt(i) == ' '){
                numSpace++;
            }
        }

        int index = str.length() - 1 +  numSpace * 2;
        str.setLength(index + 1);

        for(int i = oldLength - 1;i >= 0;i--){
            if (str.charAt(i) == ' '){
                str.setCharAt(index--,'0');
                str.setCharAt(index--,'2');
                str.setCharAt(index--,'%');
            }else {
                str.setCharAt(index--,str.charAt(i));
            }
        }
        return str.toString();
    }
    public static String replaceSpace(StringBuffer str) {
        char[] temp = str.toString().toCharArray();
        int size = temp.length;
        StringBuffer result = new StringBuffer();
        for (int i = 0;i < size;i++){
            if (' ' == temp[i]){
                result.append("%20");
                continue;
            }
            result.append(temp[i]);
        }

        return result.toString();
    }
    public static void main(String[] args) {
        System.out.println(replaceSpace2(new StringBuffer("We Are Happy.")));
    }
}
