package corejava.Ch3;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: Skye
 * @Date: 23:36 2018/7/1
 * @Description:
 */
public class Q3_12 {
    public static void main(String[] args) {
        File file = new File(".");
        File[] files = file.listFiles();
        //Arrays.sort(files, Comparator.comparing(File::isFile).thenComparing(File::getName));
        Arrays.sort(files, (a, b) -> {
            if (a.isDirectory() && !b.isDirectory()) {
                return -1;
            } else if (!a.isDirectory() && b.isDirectory()) {
                return 1;
            } else {
                return a.getName().compareTo(b.getName());
            }
        });
        for (File file1:
                files) {
            System.out.println(file1.getName());
        }
    }
}
