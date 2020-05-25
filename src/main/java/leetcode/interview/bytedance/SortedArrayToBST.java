package leetcode.interview.bytedance;

import leetcode.PrintKit;
import leetcode.tree.TreeNode;
import org.junit.Test;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/5/12 - 16:18
 * @description: <pre>
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 * </pre>
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {

        return nums == null ? null : binarySearchTreeOf(nums, 0, nums.length - 1);
    }

    public TreeNode binarySearchTreeOf(int[] nums, int left, int right) {
        if (right < left) return null;
        int mid = (left + right) / 2;
        TreeNode cur = new TreeNode(nums[mid]);
        cur.left = binarySearchTreeOf(nums, left, mid - 1);
        cur.right = binarySearchTreeOf(nums, mid + 1, right);
        return cur;
    }

    @Test
    public void test1() {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode bst = sortedArrayToBST(nums);
        System.out.println("over");
    }

}
