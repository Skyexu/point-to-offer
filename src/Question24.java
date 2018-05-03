import java.util.Arrays;

/**
 * @Author: Skye
 * @Date: 11:01 2018/5/3
 * @Description: 二叉搜索树的后序遍历序列
 *
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Question24 {
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0 )
            return false;
        // 根节点
        int root = sequence[sequence.length-1];

        //左右子树分界点
        int i = 0;
        for (; i < sequence.length - 1; i++) {
            if (sequence[i] > root)
                break;
        }
        // 如果有左子树，则判断左子树是否满足条件
        boolean left = true;
        if (i > 0)
            left = VerifySquenceOfBST(Arrays.copyOf(sequence,i));

        // 如果右子树中有小于根节点的值，则不满足条件，返回 false
        for (int j = i; j < sequence.length-2; j++) {
            if (sequence[j] < root)
                return false;
        }

        // 如果有右子树，则判断右子树是否满足条件
        boolean right = true;
        if (i < sequence.length - 1)
            right = VerifySquenceOfBST(Arrays.copyOfRange(sequence,i,sequence.length-1));
        return left && right;
    }

    public static void main(String[] args) {
        int[] sequence = new int[]{5,7,6,9,11,10,8};
        int[] sequence2 = new int[]{7,4,6,5};
        System.out.println(VerifySquenceOfBST(sequence));
        System.out.println(VerifySquenceOfBST(sequence2));
    }
}
