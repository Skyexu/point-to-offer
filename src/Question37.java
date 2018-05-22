/**
 * @Author: Skye
 * @Date: 10:07 2018/5/22
 * @Description: 两个链表的第一个公共结点
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class Question37 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null ){
            return null;
        }
        ListNode pTemp1 = pHead1;
        ListNode pTemp2 = pHead2;
        int count1 = 0, count2 = 0;
        while (pTemp1 != null) {
            count1++;
            pTemp1 = pTemp1.next;
        }
        while (pTemp2 != null) {
            count2++;
            pTemp2 = pTemp2.next;
        }
        int diff = count1 - count2;
        if (diff > 0){
            while (diff > 0){
                pHead1 = pHead1.next;
                diff--;
            }
        }else {
            while (diff < 0){
                pHead2 = pHead2.next;
                diff++;
            }
        }

        while (pHead1!=pHead2){
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
