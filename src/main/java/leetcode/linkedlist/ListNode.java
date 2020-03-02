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
}
