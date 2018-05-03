import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Skye
 * @Date: 10:20 2018/5/3
 * @Description: 从上往下打印二叉树
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class Question23 {
    // 借助队列实现
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            list.add(temp.val);
            if (temp.left != null){
                queue.offer(temp.left);
            }
            if(temp.right != null){
                queue.offer(temp.right);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(6);
        node.right = new TreeNode(14);
        ArrayList list = PrintFromTopToBottom(node);
        System.out.println(list);
    }
}
