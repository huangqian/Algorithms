package leetcode.linkedlist;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA
 * Author: huangqian
 * Date: 2020-03-03
 * Time: 00:10
 * Description 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 */
public class RemoveDuplicatesFromSortedList {

	public ListNode deleteDuplicates(ListNode head) {
		ListNode ansHead = new ListNode(0);
		ansHead.next = head;
		ListNode pre, cur;
		pre = head;
		cur = head;
		while (cur != null) {
			cur = cur.next;
			while (cur != null && cur.val == pre.val) {
				cur = cur.next;
			}
			pre.next = cur;
			pre = cur;
		}

		return ansHead.next;
	}

	@Test
	public void test1() {
		ListNode head = ListNode.of(1, 2, 2, 3, 4, 4, 5);
		head.print();
		ListNode deleteDuplicatesSortedList = deleteDuplicates(head);
		deleteDuplicatesSortedList.print();
	}
}