package leetcode.linkedlist;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA
 * Author: huangqian
 * Date: 2020-03-03
 * Time: 00:23
 * Description 分隔链表
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 示例:
 * <p>
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {

        ListNode ansHead = new ListNode(0);
        ansHead.next = head;
        ListNode left, prev, cur;
        left = ansHead;
        prev = ansHead;
        cur = head;

        while (cur != null) {
            if (cur.val < x) {
                prev.next = cur.next;
                cur.next = left.next;
                left.next = cur;
                prev = prev == left ? prev.next : prev;
                left = left.next;
                cur = prev.next;
            } else {
                prev = cur;
                cur = cur.next;
            }

        }
        return ansHead.next;
    }

    @Test
    public void test1() {
        ListNode head = ListNode.of(1, 4, 3, 2, 5, 2);
        head.print();
        ListNode deleteDuplicatesSortedList = partition(head, 3);
        deleteDuplicatesSortedList.print();
    }

    @Test
    public void test2() {
        ListNode head = ListNode.of(1, 1);
        head.print();
        ListNode deleteDuplicatesSortedList = partition(head, 2);
        deleteDuplicatesSortedList.print();
    }

    @Test
    public void test3() {
        ListNode head = ListNode.of(1, 2, 3);
        head.print();
        ListNode deleteDuplicatesSortedList = partition(head, 4);
        deleteDuplicatesSortedList.print();
    }

}