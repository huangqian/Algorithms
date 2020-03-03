package leetcode.linkedlist;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/3 - 17:31
 * @description: 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * <p>
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 * <p>
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 */
public class ReorderList {

    /**
     * 思路：遍历一遍对节点计数，并且将节点对应的序号->节点的指针放入一个Map中。
     * 题目比较明显的地方是从左往右看，k为奇数，重排序后第k个和第k+1个序号分别是对应原来的链表的k、n-k个元素
     */
    public void reorderList(ListNode head) {
        int n = 0;
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode cur = head;
        while (cur != null) {
            map.put(n, cur);
            n++;
            cur = cur.next;
        }
        cur = head;
        n--;
        for (int k = 1; k < n + 1; k++) {
            cur.next = k % 2 == 0 ? map.get(k / 2) :  map.get(n - k / 2);
            cur = cur.next;
            cur.next = null;
        }

    }

    @Test
    public void test() {
        ListNode head = ListNode.of(1, 2, 3, 4);
        reorderList(head);
        head.print();
    }

    @Test
    public void test1() {
        ListNode head = ListNode.of(1, 2, 3, 4, 5);
        reorderList(head);
        head.print();
    }
}
