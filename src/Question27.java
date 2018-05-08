import java.util.Stack;

/**
 * @Author: Skye
 * @Date: 20:04 2018/5/8
 * @Description: 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Question27 {



    // 方法一
    public static TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        midTraversal(stack, pRootOfTree);
        return toChain(stack);
    }

    // 中序遍历
    public static void midTraversal(Stack<TreeNode> stack, TreeNode root) {
        if (root == null)
            return;
        midTraversal(stack, root.left);
        stack.push(root);
        midTraversal(stack, root.right);
    }

    // 转化链表
    public static TreeNode toChain(Stack<TreeNode> stack) {
        TreeNode preNode = null;
        TreeNode nowNode = null;
        if (stack.isEmpty()) {
            return null;
        } else {
            nowNode = preNode = stack.pop();
        }
        while (!stack.isEmpty()) {
            nowNode = stack.pop();
            nowNode.right = preNode;
            preNode.left = nowNode;
            preNode = nowNode;
        }
        return nowNode;
    }
    // 方法二，直接在中序遍历的时候进行链表生成即可
    TreeNode leftHead = null;
    TreeNode rightHead = null;

    public TreeNode Convert2(TreeNode pRootOfTree) {
        midTraversal2(pRootOfTree);
        return leftHead;
    }

    public void midTraversal2(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return;
        midTraversal2(pRootOfTree.left);
        if (leftHead == null) {
            leftHead = rightHead = pRootOfTree;
        } else {
            rightHead.right = pRootOfTree;
            pRootOfTree.left = rightHead;
            rightHead = pRootOfTree;
        }
        midTraversal2(pRootOfTree.right);
    }
    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(10);
        node2.left = node;
        node2.right = node3;
        TreeNode conNode = Convert(node2);
        System.out.println(conNode.val);
        System.out.println(conNode.right.val);
        System.out.println(conNode.right.right.val);
    }
}
