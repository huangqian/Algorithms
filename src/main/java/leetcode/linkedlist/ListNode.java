package leetcode.linkedlist;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/2/29 - 21:56
 * @description: XXXX
 */
public class ListNode {

	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	public void print() {
		System.out.print(val);
		ListNode cur = this;
		while (cur.next != null) {
			cur = cur.next;
			System.out.print("->");
			System.out.print(cur.val);
		}
		System.out.println();
	}

	public static ListNode of(int... elements) {
		if (elements == null || elements.length == 0) {
			return null;
		}
		ListNode head = new ListNode(elements[0]);
		ListNode cur = head;
		for (int i = 1; i < elements.length; i++) {
			cur.next = new ListNode(elements[i]);
			cur = cur.next;
		}
		return head;
	}
}
