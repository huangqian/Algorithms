package leetcode.tree;

import leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/29 - 21:59
 * @description: 二叉树的层平均值
 * <pre>
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 *
 * 示例 1:
 *
 * 输入:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出: [3, 14.5, 11]
 * 解释:
 * 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
 * </pre>
 */
public class BinaryTreeAverageOfLevels {

    /**
     * 思路：主要考察二叉树的层序遍历
     */
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Double> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        double sum = 0.0d;
        int levelSize = 0;
        queue.add(root);
        TreeNode curr;
        while (!queue.isEmpty()) {
            levelSize = queue.size();
            sum = 0.0d;
            for (int i = 0; i < levelSize; i++) {
                curr = queue.poll();
                sum += curr.val;
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            res.add(sum / levelSize);
        }
        return res;
    }
}
