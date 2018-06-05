/**
 * @Author: Skye
 * @Date: 11:06 2018/6/5
 * @Description: 删除链表中重复的结点
 *
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class Question57 {
    public ListNode deleteDuplication(ListNode pHead) {
        //两个个节点标识
        ListNode nodePre = null;
        ListNode nodeNow = pHead;

        while (nodeNow != null){
            ListNode nextNode = nodeNow.next;
            boolean needDel = false;
            if (nextNode != null && nextNode.val == nodeNow.val){
               needDel = true;
            }

            if (!needDel){
                nodePre = nodeNow;
                nodeNow = nodeNow.next;
            }else {
                int value = nodeNow.val;
                ListNode pToBeDel = nodeNow;
                while (pToBeDel != null && pToBeDel.val == value){
                    nextNode = pToBeDel.next;
                    pToBeDel = nextNode;
                }
                if (nodePre == null){
                    pHead = nextNode;
                }else {
                    nodePre.next = nextNode;
                }
                nodeNow = nextNode;
            }


        }

        return pHead;
    }



}
