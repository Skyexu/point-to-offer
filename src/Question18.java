/**
 * @Author: Skye
 * @Date: 14:20 2018/4/11
 * @Description:
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class Question18 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 !=null){
            if (root1.val == root2.val){
                result = isSubTress(root1,root2);
            }
            if (!result){
                result = HasSubtree(root1.left,root2);
            }
            if (!result){
                result = HasSubtree(root1.right,root2);
            }

        }
        return result;
    }
    public boolean isSubTress(TreeNode root1,TreeNode root2){
        if (root2 == null){
            return true;
        }
        if (root1 == null){
            return false;
        }
        if (root1.val != root2.val){
            return false;
        }
        return isSubTress(root1.left,root2.left) && isSubTress(root1.right,root2.right);

    }
}
