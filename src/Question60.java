import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author: Skye
 * @Date: 9:45 2018/6/8
 * @Description: 按之字形顺序打印二叉树
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推
 */
public class Question60 {
    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    private Stack<TreeNode> stack = new Stack<>();
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null){
            return res;
        }
        int count = 0;

        stack.add(pRoot);
        boolean flag = true;  // 下一层从左往右入栈，即从右往左打印
        while (!stack.isEmpty()){
            count++;
            if (count % 2 == 0){
                flag = false;
            }else {
                flag = true;
            }
            putFloor(flag);

        }
        return res;
    }
    private void putFloor(boolean flag){
        Stack<TreeNode> tempStack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.val);
            if (flag){
                if (node.left != null)
                    tempStack.push(node.left);
                if (node.right != null){
                    tempStack.push(node.right);
                }
            }else {
                if (node.right != null)
                    tempStack.push(node.right);
                if (node.left != null){
                    tempStack.push(node.left);
                }
            }

        }
        res.add(list);
        stack = tempStack;
    }
}
