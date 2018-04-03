import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Skye
 * @Date: 15:53 2018/4/3
 * @Description: 反转链表
 * 输入一个链表，反转链表后，输出链表的所有元素。
 *
 * 考察代码鲁棒性
 */
public class Question16 {
    /**
     * 链表节点类
     */
    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 方法一：新建列表存储值
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null){  // 如果链表为空
            return null;
        }

        List<Integer> list = new ArrayList<>();
        if (head.next == null){   //如果链表只有一个值
            return head;
        }

        do{
            list.add(head.val);
            head = head.next;
        }while (head.next != null);
        list.add(head.val);

        ListNode  node = new ListNode(list.get(list.size() -1));
        ListNode preNode = node;
        for (int i = list.size() -2; i >= 0; i--) {
            ListNode node2 = new ListNode(list.get(i));
            preNode.next = node2;
            preNode = node2;
        }
        return node;
    }

    /**
     * 方法二： 直接改变链表方向
     * @param head
     * @return
     */
    public ListNode ReverseList2(ListNode head) {

        ListNode nextNode ;
        ListNode preNode = null;
        ListNode nowNode = head;
        ListNode reverseHead = null;

        while (nowNode != null){
            nextNode = nowNode.next;
            nowNode.next = preNode;
            if (nextNode == null)
                reverseHead = nowNode;
            preNode = nowNode;
            nowNode = nextNode;
        }
        return reverseHead;
    }
}
