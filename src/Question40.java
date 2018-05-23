/**
 * @Author: Skye
 * @Date: 19:57 2018/5/23
 * @Description: 平衡二叉树
 * <p>
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class Question40 {

    public boolean IsBalanced_Solution(TreeNode root) {
        return isBalanced(root,new int[1]);
    }

    // 用 depth 存储子树的深度，对象传递
    public boolean isBalanced(TreeNode root, int[] depth) {
        if (root == null) {
            depth[0] = 0;
            return true;
        }
        boolean left = isBalanced(root.left, depth);
        int leftDepth = depth[0];
        boolean right = isBalanced(root.right,depth);
        int rightDepth = depth[0];

        if (left && right &&Math.abs(leftDepth - rightDepth) <= 1) {
            depth[0] = leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
            return true;
        }
        return false;
    }
}
