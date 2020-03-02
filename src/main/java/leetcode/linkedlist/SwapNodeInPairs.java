package leetcode.linkedlist;

import org.junit.Test;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/2/29 - 22:52
 * @description: 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 */
public class SwapNodeInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode retHead = new ListNode(0);
        retHead.next = head;
        ListNode cur = retHead;
        ListNode q, p;

        while (cur.next != null && cur.next.next != null) {
            q = cur.next;
            p = cur.next.next;
            q.next = p.next;
            cur.next = p;
            p.next = q;
            cur = q;
        }
        return retHead.next;
    }

    @Test
    public void test(){
        ListNode l1 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(3);
        ListNode l14 = new ListNode(4);
        l1.next = l12;
        l12.next = l13;
        l13.next = l14;

        ListNode swapList = swapPairs(l1);
        swapList.print();
    }
}
