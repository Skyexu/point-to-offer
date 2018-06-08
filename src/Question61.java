import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Skye
 * @Date: 10:29 2018/6/8
 * @Description: 把二叉树打印成多行
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行
 */
public class Question61 {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int toBePrint = 1;
        int nexFloorNum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            toBePrint--;
            if (node.left != null){
                queue.offer(node.left);
                nexFloorNum++;
            }
            if (node.right != null){
                queue.offer(node.right);
                nexFloorNum++;
            }
            if (toBePrint == 0){
                res.add(list);
                list = new ArrayList<>();
                toBePrint = nexFloorNum;
                nexFloorNum = 0;
            }
        }
        return res;
    }
}
