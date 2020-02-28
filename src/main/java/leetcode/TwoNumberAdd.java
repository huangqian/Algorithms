package leetcode;

import org.junit.Test;
import org.w3c.dom.NodeList;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/2/13 - 21:19
 * @description: XXXX
 */
public class TwoNumberAdd {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = l1;
        ListNode curr = head;
        int step = 0;
        int val;
        while(l1 != null && l2 != null){
            val = (step + l1.val + l2.val) % 10;
            step = (step + l1.val + l2.val)/10;
            l1.val = val;
            curr = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null){
            val = (l1.val + step ) % 10;
            step = (l1.val + step) / 10;
            l1.val = val;
            curr = l1;
            l1 = l1.next;
        }
        if(l2 != null){
            curr.next =l2;
        }
        while (l2 != null){
            val = (l2.val + step ) % 10;
            step = (l2.val + step) / 10;
            l2.val = val;
            curr = l2;
            l2 = l2.next;

        }
        if(step > 0){
            curr.next = new ListNode(step);
        }
        return head;
    }

    @Test
    public void test1(){
        ListNode l1 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l1.next = l12;
        l1.next.next = l13;

        ListNode l2 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(6);
        l2.next = l22;
        l2.next.next = l23;

        ListNode head = addTwoNumbers(l1, l2);
        while(head != null){
            System.out.print(head.val);
            head = head.next;
        }
    }

    @Test
    public void test2(){
        ListNode l1 = new ListNode(9);

        ListNode l2 = new ListNode(9);
        ListNode l22 = new ListNode(9);

        l2.next = l22;

        ListNode head = addTwoNumbers(l1, l2);
        while(head != null){
            System.out.print(head.val);
            head = head.next;
        }
    }

    @Test
    public void test3(){
        ListNode l1 = new ListNode(5);

        ListNode l2 = new ListNode(5);

        ListNode head = addTwoNumbers(l1, l2);
        while(head != null){
            System.out.print(head.val);
            head = head.next;
        }
    }

    @Test
    public void test4(){
        ListNode l2 = new ListNode(9);

        ListNode l1 = new ListNode(9);
        ListNode l11 = new ListNode(9);

        l1.next = l11;

        ListNode head = addTwoNumbers(l1, l2);
        while(head != null){
            System.out.print(head.val);
            head = head.next;
        }
    }
}
