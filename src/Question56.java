import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Skye
 * @Date: 10:42 2018/6/5
 * @Description: 链表中环的入口结点
 * 一个链表中包含环，请找出该链表的环的入口结点
 */
public class Question56 {

    // 环在最后
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {

        Set<ListNode> set = new HashSet<>();
        while (pHead!=null){
            if (set.contains(pHead)){
                return pHead;
            }
            set.add(pHead);
            pHead = pHead.next;
        }
        return null;
    }

    /**
     方法二：
     第一步，找环中相汇点。分别用p1，p2指向链表头部，p1每次走一步，p2每次走二步，直到p1==p2找到在环中的相汇点。
     第二步，找环的入口。接上步，当p1==p2时，p2所经过节点数为2x,p1所经过节点数为x,设环中有n个节点,p2比p1多走一圈有2x=n+x; n=x;
     可以看出p1实际走了一个环的步数，再让p2指向链表头部，p1位置不变，p1,p2每次走一步直到p1==p2; 此时他们相遇的节点指向环的入口。
     */
    private class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
    }

}
