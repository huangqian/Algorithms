package leetcode.linkedlist;

import org.junit.Test;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/2 - 21:43
 * @description: 旋转链表
 * <p>
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RotateList {

    //解题思路是增加一个ansHead节点，通过该节点形成一个环
    //链表每个节点向右移动k个位置就就是直接移动ansHead直接移动n-(k % n)看，
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ansHead = new ListNode(0);
        ansHead.next = head;
        ListNode cur = head;
        int size = 1;
        while (cur.next != null) {
            cur = cur.next;
            size++;
        }
        //形成一个环
        cur.next = ansHead;
        //如果k大于size，移动size个位置相当于没有移动
        k = k % size;
        ListNode tail = cur;
        for (int n = size - k; n != 0; n--) {
            cur = ansHead.next;
            ansHead.next = cur.next;
            cur.next = ansHead;
            tail.next = cur;
            tail = cur;
        }
        //断开环
        tail.next = null;
        return ansHead.next;
    }

    @Test
    public void test1() {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i <= 5; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ListNode rotateList = rotateRight(head, 2);
        rotateList.print();
    }

    @Test
    public void test2() {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i = 1; i <= 2; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ListNode rotateList = rotateRight(head, 4);
        rotateList.print();
    }
}
