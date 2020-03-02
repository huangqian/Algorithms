package leetcode.linkedlist;

import org.junit.Test;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/2/29 - 21:12
 * @description: leetcode:19
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 */
public class RemoveNthNodeFromEndOfList {

    /**
     * 用两个指针n1，n2，他们的间距为n，当n2到达末尾的时候，n1的位置就是被删除的位置
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode n1 = newHead;
        ListNode n2 = newHead;
        for (int i = 0; i < n + 1; i++) {
            n2 = n2.next;
        }

        while (n2 != null) {
            n2 = n2.next;
            n1 = n1.next;
        }

        n1.next = n1.next.next;
        return newHead.next;
    }

    @Test
    public void test1() {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        head.next = n2;
        ListNode n3 = new ListNode(3);
        n2.next = n3;
        ListNode n4 = new ListNode(4);
        n3.next = n4;
        ListNode n5 = new ListNode(5);
        n4.next = n5;
        ListNode ans = removeNthFromEnd(head, 4);
        while (ans != null) {
            System.out.print(ans.val);
            System.out.print("->");
            ans = ans.next;
        }
    }

    @Test
    public void test2() {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        head.next = n2;
        ListNode n3 = new ListNode(3);
        n2.next = n3;
        ListNode n4 = new ListNode(4);
        n3.next = n4;
        ListNode n5 = new ListNode(5);
        n4.next = n5;
        ListNode ans = removeNthFromEnd(head, 5);
        while (ans != null) {
            System.out.print(ans.val);
            System.out.print("->");
            ans = ans.next;
        }
    }

}
