package leetcode.linkedlist;

import org.junit.Test;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/4/10 - 15:01
 * @description: 2. 两数相加
 * <pre>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * </pre>
 */
public class AddTwoNumbers {

    /**
     * 题解思路：
     * 1. 设计一个变量forward用来存储进位值。
     * 2. 每个节点的值为 (l1.val + l2.val + forward ) % 10
     * 3. 每节点向下一位进位值 forward = (l1.val + l2.val + forward ) / 10
     * 4. 组要注意便捷：
     * （1）l1或者l2任意一个链表先被计算完毕
     * （2）考虑l1与l2都被计算完后，最后一次存在的进位问题
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        int forward = 0;
        int sum;
        ListNode cur;
        ListNode pre = ans;
        //两个加速任意一个没有完成或者还存在进位
        while (l1 != null || l2 != null || forward > 0) {

            sum = forward;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            cur = new ListNode(sum % 10);
            forward = sum / 10;
            pre.next = cur;
            pre = pre.next;
        }

        return ans.next;
    }

    @Test
    public void test1() {
        ListNode l1 = ListNode.of(2, 4, 3);
        ListNode l2 = ListNode.of(5, 6, 4);
        ListNode ans = addTwoNumbers(l1, l2);
        print(ans);
    }

    @Test
    public void test2() {
        ListNode l1 = ListNode.of(2, 4, 3);
        ListNode l2 = ListNode.of(5, 6, 4);
        ListNode ans = addTwoNumbers(null, l2);
        print(ans);
    }

    public void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
        System.out.println();
    }
}
