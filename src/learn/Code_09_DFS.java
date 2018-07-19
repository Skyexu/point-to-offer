package learn;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Skye
 * @Date: 22:10 2018/7/17
 * @Description: 深度优先搜索，使用栈或者递归
 * 访问顶点v；
依次从v的未被访问的邻接点出发，对图进行深度优先遍历；直至图中和v有路径相通的顶点都被访问；
若此时图中尚有顶点未被访问，则从一个未被访问的顶点出发，重新进行深度优先遍历，直到图中所有顶点均被访问过为止。
 */
public class Code_09_DFS {
    public static void dfs(Node node){
        if (node == null){
            return;
        }
        ArrayDeque<Node> stack = new ArrayDeque<>();
        // 标记是否遍历过
        Set<Node> set = new HashSet<>();
        stack.push(node);
        set.add(node);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.value);
            for(Node next : cur.nexts){
                if (!set.contains(next)){
                    stack.push(next);
                    set.add(node);
                }
            }
        }
    }
}
