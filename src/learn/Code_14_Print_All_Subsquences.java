package learn;

/**
 * @Author: Skye
 * @Date: 18:09 2018/8/1
 * @Description: 打印字符串得所有子序列
 */
public class Code_14_Print_All_Subsquences {
    /**
     *
     * @param str 所有字符
     * @param i 当前处理的位置
     * @param res 上一层处理传给这一层的字符串
     */
    public static void printAllSubsquences(char[] str,int i ,String res){
        // 处理到最后了， Base case
        if (i == str.length){
            System.out.println(res);
            return;
        }
        // 每一次有加上当前字符和不加当前字符两种情况
        printAllSubsquences(str,i+1,res);
        printAllSubsquences(str,i+1,res + str[i]);
    }
    public static void main(String[] args) {
        String str = "abc";
        printAllSubsquences(str.toCharArray(),0,"");
    }
}
