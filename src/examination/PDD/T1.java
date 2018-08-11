package examination.PDD;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Skye
 * @Date: 19:00 2018/8/5
 * @Description:
 */
public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        print(line);
    }
    public static void print(String line){
        char[] chars = line.toCharArray();
        int k = chars.length / 4;
        char[][] charArr  = new char[k+1][k+1];

        int index1 = 0;


        for (int i = 0; i < k+1; i++) {
            for (int j = 0; j < k+1; j++) {
                charArr[i][j] = ' ';
            }
        }

        for ( int i = 0; i < k; i++) {
            charArr[0][i] = chars[index1++];
        }
        for (int i = 0; i < k; i++) {
            charArr[i][k] = chars[index1++];
        }
        for (int i = k; i > 0; i--) {
            charArr[k][i] = chars[index1++];
        }
        for (int i = k; i > 0; i--) {
            charArr[i][0] = chars[index1++];
        }

        for (int i = 0; i < k+1; i++) {
            for (int j = 0; j < k+1; j++) {
                System.out.print(charArr[i][j]);
            }
            System.out.println();
        }
    }
}
