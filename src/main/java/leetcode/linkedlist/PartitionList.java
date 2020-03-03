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
		if (head == null || head.next == null) {
			return head;
		}
		ListNode ansHead = new ListNode(0);
		ansHead.next = head;
		ListNode prev, cur, next;
		cur = head.val < x ? head.next : head;
		prev = head.val < x ? head : ansHead;
		while (cur != null && cur.next != null) {
			if (cur.next.val < x) {
				next = cur.next.next;
				cur.next.next = prev.next;
				prev.next = cur.next;
				prev = prev.next;
				cur.next = next;
			}
			cur = cur.next;

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
}