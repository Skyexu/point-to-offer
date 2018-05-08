/**
 * @Author: Skye
 * @Date: 22:36 2018/5/4
 * @Description: 复杂链表的复制
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * 解法，直接遍历 O(n*n)  哈希表 O(n)   当前方法不借助额外空间O(n)
 */
public class Question26 {
    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    public static RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null) return null;
        cloneNodes(pHead);
        connectSiblingNodes(pHead);
        return splitChain(pHead);
    }
    // clone 链表为  A->B->C   A-A'-B-B'-C-C' 的形式
    public static void cloneNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;
        while (pNode != null){
            RandomListNode pclone = new RandomListNode(pNode.label);
            pclone.next = pNode.next;
            pclone.random = null;
            pNode.next = pclone;
            pNode = pclone.next;
        }
    }
    //将复制节点连接对应的兄弟节点
    public static void connectSiblingNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;
        while (pNode != null){
            if (pNode.random != null){
                pNode.next.random = pNode.random.next;
            }
            pNode = pNode.next.next;
        }
    }
    // 拆分链表
    public static RandomListNode splitChain(RandomListNode pHead){
        RandomListNode pNode = pHead;
        RandomListNode pClonedHead = null;
        RandomListNode pCloneNode = null;
        if (pNode != null){
            pClonedHead = pCloneNode = pNode.next;
            pNode.next = pCloneNode.next;
            pNode = pNode.next;
        }
        while (pNode != null){
            pCloneNode.next = pNode.next;
            pCloneNode = pCloneNode.next;
            pNode.next = pCloneNode.next;
            pNode = pNode.next;
        }
        return pClonedHead;
    }

    public static void main(String[] args) {
        RandomListNode node = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        node.next = node2;
        node.random = node3;
        node2.next = node3;
        RandomListNode cloneNode =  Clone(node);
        System.out.println(cloneNode.label);
        System.out.println(cloneNode.random.label);
    }
}
