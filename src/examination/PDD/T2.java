package examination.PDD;

import java.util.Scanner;

/**
 * @Author: Skye
 * @Date: 19:32 2018/8/5
 * @Description:
 */
public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        int count = count(line);
        System.out.println(count);
    }
    public static int count(String line){
        int count = 0;
        for (int i = 1; i < line.length() ; i++) {
            char[] front = line.substring(0,i).toCharArray();
            char[] later = line.substring(i).toCharArray();
            count += countTwo(front,later);
        }
        return count;
    }

    public static int countTwo(char[] front,char[] later){
        // 分别计算两个数组中符合要求的数字
        // 先不加小数点判断

        int frontCount = isRightNum(front) ? 1 : 0;
        int laterCount = isRightNum(later) ? 1 : 0;

        // 加小数点判断
        for (int i = 1; i < front.length; i++) {
            char[] newFront = insertPoint(front,i);
            if (isRightNum(newFront)){
                frontCount++;
            }
        }
        for (int i = 1; i < later.length; i++) {
            char[] newLater = insertPoint(later,i);
            if (isRightNum(newLater)){
                laterCount++;
            }
        }

        return frontCount*laterCount;
    }
    public static boolean isRightNum(char[] numStr){
        int len = numStr.length;
        if (len == 1){
            return true;
        }
        if (len == 0){
            return false;
        }
        if (numStr[0] == '0'){
            if (numStr[1] == '0' || numStr[1] == '1'){
                return false;
            }
        }
        if (numStr[0] == '.' || numStr[len-1] == '.')
            return false;
        if (containsPoint(numStr) && numStr[len-1] == '0'){
            return false;
        }
        return true;
    }
    public static boolean containsPoint(char[] numStr){
        for (int i = 0; i < numStr.length; i++) {
            if (numStr[i] == '.'){
                return true;
            }
        }
        return false;
    }
    public static char[] insertPoint(char[] numStr,int index){
        char[] newChar = new char[numStr.length + 1];
        for (int i = 0; i < index; i++) {
            newChar[i] = numStr[i];
        }
        newChar[index] = '.';
        for (int i = index + 1; i < newChar.length; i++) {
            newChar[i] = numStr[i-1];
        }
        return newChar;
    }
}
