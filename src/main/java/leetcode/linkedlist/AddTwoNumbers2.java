package leetcode.linkedlist;

import org.junit.Test;

import java.util.Stack;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/5/9 - 15:44
 * @description: <pre>
 *
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 *  
 *
 * 进阶：
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 *  
 *
 * 示例：
 *
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 */
public class AddTwoNumbers2 {

    /**
     * 解题思路：
     * 没有没有进阶的要求，直接将l1，l2反转，然后逐步进行加法计算。
     * 但是，这里要求不允许反转，那么这里只能使用栈来进行计算
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        Stack<ListNode> stack1 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        Stack<ListNode> stack2 = new Stack<>();
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }
        int forward = 0;
        int sum;
        ListNode n1, n2;
        ListNode cur;
        while (!stack1.isEmpty() || !stack2.isEmpty() || forward != 0) {
            n1 = stack1.isEmpty() ? null : stack1.pop();
            n2 = stack2.isEmpty() ? null : stack2.pop();
            sum = (n1 == null ? 0 : n1.val) + (n2 == null ? 0 : n2.val) + forward;
            cur = new ListNode(sum % 10);
            cur.next = dummy.next;
            dummy.next = cur;
            forward = sum / 10;
        }
        return dummy.next;
    }


    @Test
    public void test01() {
        ListNode l1 = ListNode.of(7, 2, 4, 3);
        ListNode l2 = ListNode.of(5, 6, 4);
        ListNode res = addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.print(res.val);
            if (res.next != null) {
                System.out.print(" -> ");
            }
            res = res.next;
        }
        System.out.println();
    }
}
