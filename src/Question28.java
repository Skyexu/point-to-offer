import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * @Author: Skye
 * @Date: 21:40 2018/5/8
 * @Description: 字符串的排列
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 递归，回溯
 */
public class Question28 {

    // 方法一：自己写的递归，思路是拿出数组中每一个字符加到字符串中，接下来的数组再递归不断加入
    public ArrayList<String> Permutation(String str) {
        char[] chars = str.toCharArray();
        HashSet<String> set = new HashSet<>();
        getAll(set,new StringBuilder(),chars);
        ArrayList<String> resList = new ArrayList<>();
        resList.addAll(set);
        Collections.sort(resList);
        return resList;
    }

    public void getAll(HashSet<String> set, StringBuilder str, char[] charArr){

        for (int i = 0; i < charArr.length; i++) {
            StringBuilder newStr = new StringBuilder();
            newStr.append(str).append(charArr[i]);
            if (charArr.length > 1){
                char[] newCharArr = new char[charArr.length-1];
                int index = 0;
                for (int j = 0; j < charArr.length; j++) {
                    if (j == i)
                        continue;
                    newCharArr[index++] = charArr[j];
                }
                getAll(set,newStr, newCharArr);
            }else {
                set.add(newStr.toString());
            }
        }
    }
    // 优化递归代码，减少存储空间
    public ArrayList<String> Permutation2(String str) {
        ArrayList<String> resList = new ArrayList<>();
        if (str!=null && str.length()>0){
            char[] chars = str.toCharArray();
            getAll2(resList,0,chars);
            Collections.sort(resList);
        }

        return resList;
    }
    /**
     *
     * @param list
     * @param index  标记当前递归到的数组下标
     * @param charArr
     */
    public void getAll2(ArrayList<String> list, int index, char[] charArr){
        if (index == charArr.length-1){
            if (!list.contains(String.valueOf(charArr))){
                list.add(String.valueOf(charArr));
            }
            return;
        }
        //注意：从index自己开始
        for (int i = index; i < charArr.length; i++) {
                swap(charArr,index,i);
                getAll2(list,index+1,charArr);
                // 交换回来，由于递归的性质，重新交换后保持数组不变
                swap(charArr,i,index);

        }
    }
    public void swap(char[] chars,int i,int j){
        char tmp = chars[i];
        chars[i] =  chars[j];
        chars[j] = tmp;
    }
    public static void main(String[] args) {
        String str = "abc";
        Question28 question28 = new Question28();
        ArrayList<String> list = question28.Permutation2(str);
        for (String s:
             list) {
            System.out.println(s);
        }
    }
}
