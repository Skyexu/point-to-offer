import java.util.ArrayList;

/**
 * @Author: Skye
 * @Date: 10:11 2018/5/4
 * @Description: 二叉树中和为某一值的路径
 *
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *
 * 解法：需要首先遍历到叶节点，则需使用深度优先，树的深度优先，有前中后三种遍历方式，此题需用先序遍历
 * 注意，过后需要从列表减去当前节点，避免重复计算
 */
public class Question25 {
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (root == null || target <= 0)
            return lists;

        preorderTraversal(root,lists,new ArrayList<Integer>(),target,0);
        return lists;
    }
    public static void preorderTraversal(TreeNode root,ArrayList<ArrayList<Integer>> lists,ArrayList<Integer> pathList,int target,int sum){
        if (root == null){
            return;
        }
        pathList.add(root.val);
        sum += root.val;
        if (target == sum && root.left == null && root.right == null)
            lists.add(new ArrayList<>(pathList));
        preorderTraversal(root.left,lists,pathList,target,sum);
        preorderTraversal(root.right,lists,pathList,target,sum);
        // 减去已遍历后的节点
        pathList.remove(pathList.size()-1);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(2);
        ArrayList<ArrayList<Integer>> lists = FindPath(node,3);
        System.out.println(lists);
    }
}
