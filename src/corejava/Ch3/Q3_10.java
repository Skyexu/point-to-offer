package corejava.Ch3;

import java.io.File;
import java.io.FileFilter;

/**
 * @Author: Skye
 * @Date: 23:13 2018/7/1
 * @Description:
 */
public class Q3_10 {
    public static File[] getDirectories(String path){
        File file = new File(path);
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
        return files;
    }
    // 用 方法表达式 代替 FileFilter
    public static File[] getDirectories2(String path){
        File file = new File(path);
        File[] files = file.listFiles(pathname -> pathname.isDirectory());
        return files;
    }
    // 用 lambda 代替 FileFilter
    public static File[] getDirectories3(String path){
        File file = new File(path);
        File[] files = file.listFiles(File::isDirectory);
        return files;
    }
    public static void main(String[] args) {
        File[] dirs = getDirectories3("C:\\Users\\Skye");
        for(File dir : dirs) {
            System.out.println(dir);
        }
    }
}
