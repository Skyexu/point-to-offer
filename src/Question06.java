import java.util.Arrays;

/**
 * @Author: Skye
 * @Date: 19:52 2018/2/28
 * @Description: 重建二叉树
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * 二叉树遍历资料：https://www.jianshu.com/p/456af5480cee
 */
public class Question06 {
    // 根据前序和中序，重建二叉树
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }
        return root;
    }

    // 方法二，不使用 Arrays.copyOfRange
    public TreeNode reConstructBinaryTree2(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree3(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }


    private TreeNode reConstructBinaryTree3(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startIn > endIn || startPre > endPre){
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i < endIn + 1; i++) {
            if (in[i] == pre[startPre]) {
                root.left = reConstructBinaryTree3(pre, startPre+1, i - startIn + startPre , in, startIn, i-1);
                root.right = reConstructBinaryTree3(pre, i - startIn  + startPre + 1, endPre, in, i + 1, endIn);
                break;
            }

        }
        return root;
    }

    // 递归先序遍历
    public static void recursionPreorderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            recursionPreorderTraversal(root.left);
            recursionPreorderTraversal(root.right);
        }
    }

    public static void main(String[] args){
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        Question06 question06 = new Question06();
        TreeNode root = question06.reConstructBinaryTree2(pre,in);
        recursionPreorderTraversal(root);
    }
}
