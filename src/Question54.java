/**
 * @Author: Skye
 * @Date: 10:37 2018/6/4
 * @Description: 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class Question54 {
    public boolean isNumeric(char[] str) {

        if (str == null || str.length == 0)
            return false;
        int index = 0;
        if (str[index] == '+' || str[index] == '-')
            index++;

        boolean numeric = true;
        index = scanDigits(str,index);
        if (index < str.length){
            if (str[index] == '.'){
                ++index;
                index = scanDigits(str,index);
                if (index < str.length && (str[index] == 'e' || str[index] == 'E')){
                    int[] indexs =  new int[]{index};
                    numeric = isExponential(str,indexs);
                    index = indexs[0];
                }
            }else if (str[index] == 'e' || str[index] == 'E'){
                int[] indexs =  new int[]{index};
                numeric = isExponential(str,indexs);
                index = indexs[0];
            }else {
                numeric = false;
            }
        }
        return numeric && (index == str.length);
    }
    private int scanDigits(char[] chars,int index){
        while (index < chars.length && chars[index] >= '0' && chars[index] <= '9'){
            ++index;
        }
        return index;
    }
    private boolean isExponential(char[] str,int[] index){
        if (str[index[0]] != 'e' && str[index[0]] != 'E')
            return false;
        ++index[0];
        if (index[0] < str.length && (str[index[0]] == '+' || str[index[0]] == '-'))
            index[0]++;
        if (index[0] >= str.length)
            return false;
        index[0] = scanDigits(str,index[0]);
        return index[0] == str.length;
    }



/**
 * 正则表达式解法
 public boolean isNumeric(char[] str) {
    String string = String.valueOf(str);
    return string.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
 }
*/
    /*
    以下对正则进行解释:
    [\\+\\-]?            -> 正或负符号出现与否
    \\d*                 -> 整数部分是否出现，如-.34 或 +3.34均符合
    (\\.\\d+)?           -> 如果出现小数点，那么小数点后面必须有数字；
                            否则一起不出现
    ([eE][\\+\\-]?\\d+)? -> 如果存在指数部分，那么e或E肯定出现，+或-可以不出现，
                            紧接着必须跟着整数；或者整个部分都不出现
    */
    public static void main(String[] args) {
        Question54 question54 = new Question54();
        String str = "12e";
        System.out.println(question54.isNumeric(str.toCharArray()));
    }
}
