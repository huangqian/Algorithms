package leetcode.linkedlist;

import org.junit.Test;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/2 - 22:59
 * @description: 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 */
public class RemoveDuplicatesFromSortedList2 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode ansHead = new ListNode(0);
        ansHead.next = head;
        ListNode pre, start, end;
        pre = ansHead;
        start = end = head;
        int n;
        while (end != null && end.next != null) {
            n = 0;
            do {
                end = end.next;
                n++;
            } while (end != null && end.val == start.val);
            if (n >= 2) {
                pre.next = end;
            } else {
                pre = pre.next;
            }
            start = end;
        }
        return ansHead.next;
    }

    @Test
    public void test1() {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i <= 5; i++) {
            if (i % 2 == 0) {
                cur.next = new ListNode(i);
                cur = cur.next;
            }
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        head.print();
        ListNode deleteDuplicatesSortedList = deleteDuplicates(head);
        deleteDuplicatesSortedList.print();
    }

    @Test
    public void test2() {
        ListNode head = new ListNode(1);
        ListNode cur = head;

        for (int k = 0; k < 2; k++) {
            cur.next = new ListNode(1);
            cur = cur.next;
        }

        for (int i = 2; i <= 5; i++) {
            if (i % 2 == 0) {
                cur.next = new ListNode(i);
                cur = cur.next;
            }
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        head.print();
        ListNode deleteDuplicatesSortedList = deleteDuplicates(head);
        deleteDuplicatesSortedList.print();
    }
}
