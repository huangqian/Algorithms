package leetcode.linkedlist;

import org.junit.Test;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/2/24 - 22:22
 * @description: 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {

        ListNode cur = head;
        ListNode revHead = null;
        ListNode revNext;
        while (cur != null) {
            revNext = revHead;
            revHead = cur;
            cur = cur.next;
            revHead.next = revNext;

        }
        return revHead;
    }

    @Test
    public void testCase1() {

        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i <= 5; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ListNode revHead = reverseList(head);
        System.out.println(revHead);

    }
}
