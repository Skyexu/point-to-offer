/**
 * @Author: Skye
 * @Date: 21:26 2018/6/6
 * @Description: 二叉树的下一个结点
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class Question58 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode == null){
            return null;
        }
        TreeLinkNode pNext = null;
        // 如果右子树不为空，则下一个节点在右子树
        if (pNode.right != null){
            TreeLinkNode right = pNode.right;
            while (right.left != null){
                right = right.left;
            }
            pNext =  right;
        }else if (pNode.next != null){
            TreeLinkNode pCur = pNode;
            TreeLinkNode pParent = pNode.next;
            while (pParent != null && pCur == pParent.right){
                pCur = pParent;
                pParent = pParent.next;
            }
            pNext = pParent;
        }

        return pNext;
    }
}
