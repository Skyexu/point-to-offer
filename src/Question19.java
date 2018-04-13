/**
 * @Author: Skye
 * @Date: 10:49 2018/4/13
 * @Description:
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Question19 {
    public static void Mirror(TreeNode root) {
        if (root == null){
            return;
        }
        if (root.right != null || root.left != null){
            TreeNode tempNode = root.right;
            root.right = root.left;
            root.left = tempNode;
        }
        if (root.right != null){
            Mirror(root.right);
        }
        if (root.left!=null){
            Mirror(root.left);
        }

    }

    public static void main(String[] args) {
        TreeNode tempNode = null;
        Mirror(tempNode);
    }
}
