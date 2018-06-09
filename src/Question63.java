/**
 * @Author: Skye
 * @Date: 14:24 2018/6/9
 * @Description: 二叉搜索树的第k个结点
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。
 * 例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 *
 * 二叉搜索树中序遍历即从小到大的排序
 */
public class Question63 {
    int index = 0;
    TreeNode node = null;
    TreeNode KthNode(TreeNode pRoot, int k) {
        middleTraversal(pRoot,k);
        return node;
    }
    private void middleTraversal(TreeNode pRoot,int k){
        if (pRoot == null || index == k){
            return;
        }
        middleTraversal(pRoot.left,k);
        index++;
        if (index == k){
            node = pRoot;
            return;
        }
        middleTraversal(pRoot.right,k);
    }
}
