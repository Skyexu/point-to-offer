/**
 * @Author: Skye
 * @Date: 10:29 2018/6/9
 * @Description: 序列化二叉树
 *
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * 使用前序遍历来实现
 */
public class Question62 {

    String Serialize(TreeNode root) {
        if (root == null){
            return null;
        }
        StringBuilder str = new StringBuilder();
        serializeToStr(root,str);
        return str.toString();
    }
    private void serializeToStr(TreeNode root,StringBuilder str){
        // 以#代表 null
        if (root == null){
            str.append("#").append(",");
            return;
        }
        str.append(root.val).append(",");
        serializeToStr(root.left,str);
        serializeToStr(root.right,str);
    }
    TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0){
            return null;
        }
        String[] values = str.split(",");
        int[] index = new int[]{0};
        TreeNode root =  deserializeToTree(values,index);
        return root;
    }
    private TreeNode deserializeToTree(String[] values,int[] index){
        if (values[index[0]].equals("#")){
             return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(values[index[0]]));
        index[0]++;
        node.left = deserializeToTree( values, index);
        index[0]++;
        node.right = deserializeToTree( values, index);

        return node;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        Question62 question62 = new Question62();
        String str = question62.Serialize(root);
        TreeNode node = question62.Deserialize(str);
    }
}
