/**
 * @Author: Skye
 * @Date: 18:55 2018/4/3
 * @Description: 合并两个排序的链表
 *
 *  输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Question17 {
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
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null && list2 ==null){
            return null;
        }else if(list1 == null){
            return list2;
        }else if (list2 == null){
            return list1;
        }

        ListNode oneIndex = list1;
        ListNode twoIndex = list2;
        ListNode returnHead = null;
        ListNode lastNode = null;

        if (oneIndex.val < twoIndex.val){
            returnHead = oneIndex;
            oneIndex = oneIndex.next;
        }else {
            returnHead = twoIndex;
            twoIndex = twoIndex.next;
        }
        lastNode = returnHead;


        while (oneIndex != null && twoIndex != null){
            if (oneIndex.val < twoIndex.val){
                lastNode.next = oneIndex;
                lastNode = lastNode.next;
                oneIndex = oneIndex.next;
            }else {
                lastNode.next = twoIndex;
                lastNode = lastNode.next;
                twoIndex = twoIndex.next;
            }
        }
        if (oneIndex != null){
            lastNode.next = oneIndex;
        }else if (twoIndex != null){
            lastNode.next = twoIndex;
        }

        return returnHead;
    }
}
