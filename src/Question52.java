import java.util.ArrayList;
/**
 * @Author: Skye
 * @Date: 15:30 2018/5/31
 * @Description: 构建乘积数组
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class Question52 {
    public int[] multiply(int[] A) {
        if (A == null || A.length <= 1){
            return new int[0];
        }
        int[] B = new int[A.length];
        //int[] C = new int[A.length];
        //int[] D = new int[A.length];
        //构造 A[0]*A[1]*...*A[i-1] 为 C[i]   A[i+1]*...*A[n-1] 为 D[i]

        B[0] = 1;
        for (int i = 1; i < A.length; i++) {
            B[i] = B[i-1] * A[i-1];
        }
        int temp = 1;
        for (int i = A.length - 2; i >=0 ; i--) {
            temp *= A[i+1];
            B[i] *= temp;
        }

        return B;
    }

}
