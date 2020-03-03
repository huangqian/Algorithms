package leetcode.linkedlist;

import org.junit.Test;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/3 - 15:45
 * @description: 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 */
public class ReverseList2 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        int i = 1;
        for (; i < m; i++) {
            pre = pre.next;
        }
        ListNode mNode = pre.next;
        ListNode cur = pre.next;
        ListNode next;
        for (; i <= n; i++) {
            next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        mNode.next = cur;
        return dummy.next;
    }

    @Test
    public void test() {
        ListNode head = ListNode.of(1, 2, 3, 4, 5);
        ListNode reverseList = reverseBetween(head, 2, 4);
        reverseList.print();
    }
}
