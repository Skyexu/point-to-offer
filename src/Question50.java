/**
 * @Author: Skye
 * @Date: 15:39 2018/5/30
 * @Description: 把字符串转换成整数
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 */
public class Question50 {
    public int StrToInt(String str) {
        if (str.equals("") || str.length() == 0)
            return 0;
        char[] chars = str.toCharArray();
        int num = 0;
        int flag = 1;
        for (int i = chars.length-1; i >= 0; i--) {
            char s = chars[i];
            if (i == 0 && (s == '-')){
                num *= -1;
                continue;
            }else if (i == 0 && (s == '+')){
                continue;
            }

            if (isNumber(s)){
                num += (s - '0') * flag;
                flag *= 10;
            }else {
                return 0;
            }
        }
        return num;
    }
    public  boolean isNumber(char s){
        if ((s - '0') >= 0 && (s - '0') <= 9){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        Question50 quesion50 = new Question50();
        System.out.println(quesion50.StrToInt("-123"));
    }
}
