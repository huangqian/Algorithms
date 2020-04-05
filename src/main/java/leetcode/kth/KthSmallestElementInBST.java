package leetcode.kth;

import leetcode.tree.TreeNode;

import java.util.LinkedList;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/4/3 - 22:38
 * @description: 二叉搜索树中第K小的元素
 * <pre>
 *   给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 3
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 * </pre>
 */
public class KthSmallestElementInBST {

    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        kthSmallestByRecursive(root, k, queue);
        return queue.removeLast().val;
    }

    public void kthSmallestByRecursive(TreeNode root, int k, LinkedList<TreeNode> queue) {
        if (root == null || k == queue.size()) return;
        if (root.left != null) kthSmallestByRecursive(root.left, k, queue);
        if (queue.size() < k) {
            queue.addLast(root);
        }
        if (root.right != null && queue.size() < k) kthSmallestByRecursive(root.right, k, queue);
    }
}
