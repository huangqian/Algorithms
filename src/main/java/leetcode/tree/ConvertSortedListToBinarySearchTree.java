package leetcode.tree;

import leetcode.linkedlist.ListNode;
import org.junit.Test;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/3 - 18:44
 * @description: 有序链表转二叉搜索树
 * <p>
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * <p>
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class ConvertSortedListToBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        int size = 0;
        ListNode cur;
        for (cur = head; cur != null; cur = cur.next) size++;
        int[] nums = new int[size];
        cur = head;
        for (int i = 0; i < size; i++, cur = cur.next) nums[i] = cur.val;

        return recursiveConstructBST(nums, 0, size - 1);
    }

    public TreeNode recursiveConstructBST(int[] nums, int start, int end) {
        int middle = (start + end) / 2;
        TreeNode node = new TreeNode(nums[middle]);
        if (start < middle) node.left = recursiveConstructBST(nums, start, middle - 1);
        if (end > middle) node.right = recursiveConstructBST(nums, middle + 1, end);
        return node;
    }

    @Test
    public void test1() {
        ListNode head = ListNode.of(-10, -3, 0, 5, 9);
        TreeNode bst = sortedListToBST(head);
        System.out.println(bst);
    }

}
