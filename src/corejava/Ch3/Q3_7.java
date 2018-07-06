package corejava.Ch3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Author: Skye
 * @Date: 22:12 2018/7/1
 * @Description:
 */
public class Q3_7 {
    public static  void luckySort(ArrayList<String> strings, Comparator<String> cmp){
        ArrayList<String> tmp = new ArrayList<>(strings);
        Collections.sort(strings,cmp);
        int count = 0;
        while (!strings.equals(tmp)){
            System.out.println(++count);
            Collections.shuffle(strings);
        }

    }
    public static void main(String[] args) {
        ArrayList<String> stooges = new ArrayList<>();
        stooges.add("moe");
        stooges.add("Curly");
        stooges.add("Schemp");
        luckySort(stooges,String::compareTo);
    }
}
