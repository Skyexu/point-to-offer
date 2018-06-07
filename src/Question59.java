/**
 * @Author: Skye
 * @Date: 10:34 2018/6/7
 * @Description: 对称的二叉树
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class Question59 {
    // 比较二叉树前序遍历和对称前序遍历是否相同，即遍历根节点后，先遍历左子树与先遍历右子树的序列比较
    // 注意需要考虑空指针
    boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetrical(pRoot,pRoot);
    }
    boolean isSymmetrical(TreeNode pRoot1 ,TreeNode pRoot2){
        // 两个同时为 null
        if (pRoot1 == null && pRoot2 == null){
            return true;
        }
        // 其中一个为 null,即两个不同，返回 false
        if (pRoot1 == null || pRoot2 == null){
            return false;
        }

        if (pRoot1.val != pRoot2.val){
            return false;
        }
        return isSymmetrical(pRoot1.left,pRoot2.right) && isSymmetrical(pRoot1.right,pRoot2.left);
    }
}
