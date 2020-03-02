package leetcode.linkedlist;

import org.junit.Test;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/2/29 - 22:22
 * @description: 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode head = new ListNode(0);
        head.next = lists[0];
        ListNode cur;
        ListNode mergedList;
        for (int i = 1; i < lists.length; i++) {
            mergedList = head.next;
            cur = head;
            while (mergedList != null && lists[i] != null) {
                if (mergedList.val <= lists[i].val) {
                    cur.next = mergedList;
                    mergedList = mergedList.next;
                } else {
                    cur.next = lists[i];
                    lists[i] = lists[i].next;
                }
                cur = cur.next;
            }

            cur.next = mergedList != null ? mergedList : lists[i];

        }
        return head.next;
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(1);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(5);
        l1.next = l12;
        l12.next = l13;

        ListNode l2 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        l2.next = l22;
        l22.next = l23;

        ListNode l3 = new ListNode(2);
        ListNode l31 = new ListNode(6);
        l3.next = l31;

        ListNode[] lists = {l1, l2, l3};

        ListNode mergeList = mergeKLists(lists);
        mergeList.print();
    }
}
