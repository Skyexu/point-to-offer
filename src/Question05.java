import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author: Skye
 * @Date: 21:23 2017/10/19
 * @Description:
 *
 * 题目描述
  输入一个链表，从尾到头打印链表每个节点的值。

 */


public class Question05 {
    public static ArrayList<Integer> arrayList = new ArrayList<>();

    /**
     * 使用递归形式
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

    /**
     * 使用栈
     * @param listNode
     */
    public static void printListFromTailToHead2(ListNode listNode){
        Stack<ListNode> stack = new Stack<>();

        while (listNode != null){
            stack.push(listNode);
            listNode = listNode.next;
        }

        while (!stack.isEmpty()){
            arrayList.add(stack.pop().val);
        }
    }
    public static void main(String[] args) {
        ListNode node = new ListNode(5);
        node.next = new ListNode(4);
        node.next.next = new ListNode(3);

        printListFromTailToHead(node);
        for(Integer i : arrayList){
            System.out.printf(i +" ");
        }

    }

    /**
     * 节点类
     */
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
