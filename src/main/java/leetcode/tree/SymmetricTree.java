package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/4/3 - 18:29
 * @description: 101. 对称二叉树
 * <pre>
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 说明:
 *
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * </pre>
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {

        return isSymmetricByRecursive(root, root);
    }

    public boolean isSymmetricByRecursive(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        return isSymmetricByRecursive(t1.left, t2.right) && isSymmetricByRecursive(t1.right, t2.left);
    }

    public boolean isSymmetricByIterator(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        TreeNode t1, t2;
        while (!queue.isEmpty()) {
            t1 = queue.poll();
            t2 = queue.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;
    }
}
