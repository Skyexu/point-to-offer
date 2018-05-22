import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: Skye
 * @Date: 9:06 2018/5/19
 * @Description: 把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class Question33 {
    // 先定义两个数的大小规则，然后使用排序算法即可
    public static String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0){
            return "";
        }
        //将数值数组转换成字符串数组，防止两数相加的大数问题
        String[] arrStr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arrStr[i] = numbers[i] + "";
        }

        Arrays.sort(arrStr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String first = o1 + o2;
                String second = o2 + o1;
                return first.compareTo(second);
            }
        });
        StringBuilder res  = new StringBuilder();
        for (int i = 0; i < arrStr.length; i++) {
            res.append(arrStr[i]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,32,321} ;
        System.out.println(PrintMinNumber(arr));
    }
}
