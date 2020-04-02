package leetcode.linkedlist;

import java.util.HashSet;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/4/2 - 16:01
 * @description: 160. 相交链表
 * <pre>
 *     编写一个程序，找到两个单链表相交的起始节点。
 *
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists。
 * </pre>
 */
public class IntersectionOfTwoLinkedList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = headA;
        while (cur != null) {
            set.add(cur);
            cur = cur.next;
        }
        cur = headB;
        while (cur != null && !set.contains(cur)) cur = cur.next;
        return cur;
    }

    /**
     * 两个指针走过相同的距离就会在相交点汇合
     * 题解参考：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/tu-jie-xiang-jiao-lian-biao-by-user7208t/
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
