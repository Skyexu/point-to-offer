package learn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: Skye
 * @Date: 16:56 2018/8/1
 * @Description: 输入： 参数1，正数数组costs 参数2，正数数组profits 参数3，
正数k 参数4，正数m
costs[i]表示i号项目的花费 profits[i]表示i号项目在扣除花
费之后还能挣到的钱(利润) k表示你不能并行、只能串行的最多
做k个项目 m表示你初始的资金
说明：你每做完一个项目，马上获得的收益，可以支持你去做下
一个 项目。
输出： 你最后获得的最大钱数

 解法：贪心，  以堆来做
 */
public class Code_12_IPO {
    class Node{
        private int p;
        private int c;

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }

        public int getP() {
            return p;
        }

        public int getC() {
            return c;
        }

    }
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        Node[] nodes = new Node[Profits.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(Profits[i], Capital[i]);
        }
        PriorityQueue<Node> minCostQ = new PriorityQueue<>(Comparator.comparingInt(Node::getC));
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(Comparator.comparingInt(Node::getP).reversed());
        minCostQ.addAll(Arrays.asList(nodes));

        for (int i = 0; i < k; i++) {
            while (!minCostQ.isEmpty() && minCostQ.peek().getC() < W){
                maxProfitQ.add(minCostQ.poll());
            }
            if (maxProfitQ.isEmpty()){
                return W;
            }
            W += maxProfitQ.poll().getP();
        }
        return W;
    }
}
