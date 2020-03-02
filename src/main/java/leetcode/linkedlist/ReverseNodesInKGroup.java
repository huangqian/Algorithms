package leetcode.linkedlist;

import org.junit.Test;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/2/29 - 23:40
 * @description: 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例 :
 * <p>
 * 给定这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明 :
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 */
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null) return head;
        ListNode retHead = new ListNode(0);
        ListNode cur, pre, next, n0, monitor;
        int count = 0;
        pre = retHead;
        cur = head;
        int step = 0;
        while (cur != null) {
            monitor = cur;
            while (monitor != null && step < k) {
                monitor = monitor.next;
                step++;
            }
            //检查后续是否还有足够的翻转长度
            if (step % k == 0) {
                //翻转空间充足
                count++;
                n0 = cur;
                while (count % (k + 1) != 0 && cur != null) {
                    next = pre.next;
                    pre.next = cur;
                    cur = cur.next;
                    pre.next.next = next;
                    count++;
                }
                pre = n0;
                step = 0;
            } else {
                //翻转空间不足
                pre.next = cur;
                break;
            }
        }
        return retHead.next;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode ansHead = new ListNode(0);
        ansHead.next = head;
        ListNode pre = ansHead;
        ListNode start, end, next;
        end = pre;

        while (end != null) {
            for (int i = 0; i < k & end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            next = end.next;
            end.next = null;
            start = pre.next;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = start;

        }


        return ansHead.next;
    }

    public ListNode reverse(ListNode head) {

        ListNode next;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            next = cur;
            cur = cur.next;
            next.next = pre;
            pre = next;
        }
        return pre;
    }


    @Test
    public void test() {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i <= 11; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ListNode reverseLinkedList = reverseKGroup(head, 3);
        reverseLinkedList.print();
    }


    @Test
    public void testReversKGroup2() {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i <= 11; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ListNode reverseLinkedList = reverseKGroup2(head, 3);
        reverseLinkedList.print();
    }

    @Test
    public void testReversKGroup21() {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i <= 2; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ListNode reverseLinkedList = reverseKGroup2(head, 2);
        reverseLinkedList.print();
    }


    @Test
    public void testReverse() {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i <= 11; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ListNode reverseLinkedList = reverse(head);
        reverseLinkedList.print();
    }


    @Test
    public void test1() {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i <= 4; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ListNode reverseLinkedList = reverseKGroup(head, 3);
        reverseLinkedList.print();
    }

    @Test
    public void test0() {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i <= 2; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ListNode reverseLinkedList = reverseKGroup(head, 3);
        reverseLinkedList.print();
    }


    @Test
    public void test2() {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i <= 10; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ListNode reverseLinkedList = reverseKGroup(head, 4);
        reverseLinkedList.print();
    }

    @Test
    public void test3() {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i <= 5; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ListNode reverseLinkedList = reverseKGroup(head, 2);
        reverseLinkedList.print();
    }

    @Test
    public void test4() {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i <= 3; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ListNode reverseLinkedList = reverseKGroup(head, 3);
        reverseLinkedList.print();
    }
}
