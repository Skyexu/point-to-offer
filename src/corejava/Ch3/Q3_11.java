package corejava.Ch3;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

/**
 * @Author: Skye
 * @Date: 23:25 2018/7/1
 * @Description:
 */
public class Q3_11 {
    public static String[] listFile(String path,String fileExtend){
        File file = new File(path);
        String[] files = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith("."+ fileExtend);
            }
        });
        return files;
    }

    // 用 lambda 代替 FileFilter
    public static String[] listFile2(String path,String fileExtend){
        File file = new File(path);
        return file.list((dir,name) -> name.endsWith("."+ fileExtend));
    }
    public static void main(String[] args) {
        String[] dirs = listFile("C:\\Users\\Skye","mp4");
        for(String dir : dirs) {
            System.out.println(dir);
        }
    }
}
