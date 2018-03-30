import java.util.List;

/**
 * @Author: Skye
 * @Date: 21:54 2018/3/30
 * @Description: 链表中倒数第k个结点
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * 考查代码鲁棒性
 */
public class Question15 {

    public static ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k <= 0){
            return null;
        }
        // 两个指针，第一个先遍历到第 k个节点，即走 k-1 步
        // 然后后面的指针开始一起移动
        ListNode pre = head;
        ListNode last = head;
        for (int i = 0; i < k - 1; i++) {
            if (pre.next == null)
                return null;
            pre = pre.next;
        }
        while (pre.next != null){
            pre = pre.next;
            last = last.next;
        }
        return last;
    }

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode getnode = FindKthToTail(node1,1);
        System.out.println(getnode.val);
        ListNode getnode1 = FindKthToTail(null,100);
    }
}
