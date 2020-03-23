package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/23 - 14:14
 * @description: 199. 二叉树的右视图
 *
 * <pre>
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * </pre>
 */
public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<TreeNode> currentLevelQueue = new LinkedList<>();
        LinkedList<TreeNode> nextLevelQueue = new LinkedList<>();
        nextLevelQueue.addLast(root);
        TreeNode cur = null;
        while (!nextLevelQueue.isEmpty()) {
            while (!nextLevelQueue.isEmpty()) {
                currentLevelQueue.addLast(nextLevelQueue.poll());
            }

            while (!currentLevelQueue.isEmpty()) {
                cur = currentLevelQueue.pollFirst();
                if (cur.left != null) nextLevelQueue.addLast(cur.left);
                if (cur.right != null) nextLevelQueue.addLast(cur.right);
            }
            if (cur != null) res.add(cur.val);
        }

        return res;
    }
}
