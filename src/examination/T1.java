package examination;

import java.util.Scanner;

/**
 * @Author: Skye
 * @Date: 19:01 2018/3/28
 * @Description:
 */
public class T1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rake = new int[21];
        int i = 0;
        while ((scanner.hasNext())){
            int n = scanner.nextInt();
            rake[i++] = n;
            if (i == 21)
                break;
        }
        int max = 0;
        int index = 0;
        for (int j = 0; j < rake.length-3; j++) {
            int k = j + 3;
            int sum = 0;
            for (int l = j; l <= k; l++) {
                sum += rake[l];
            }
            if (sum > max){
                max = sum;
                index = j;
            }
        }
        System.out.println(index);
    }
}
