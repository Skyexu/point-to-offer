package learn;

import java.util.*;

/**
 * @Author: Skye
 * @Date: 0:55 2018/7/18
 * @Description: 广度优先搜索
 */
public class Code_10_BFS {
    public static void bfs(Node node){
        if (node == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        // 标记是否遍历过
        Set<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.value);
            for (Node next: cur.nexts) {
                if (!set.contains(next)){
                    queue.add(next);
                    set.add(next);
                }
            }
        }
    }
}
