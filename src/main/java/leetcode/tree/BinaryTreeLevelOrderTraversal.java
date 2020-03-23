package leetcode.tree;

import org.junit.Test;

import java.util.*;

;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/22 - 21:24
 * @description: 102. 二叉树的层次遍历
 *
 * <pre>
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * </pre>
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        queue.add(root);
        List<Integer> valsOfLevel = null;
        TreeNode nextLevelStartNode = root;
        TreeNode curr;
        while (!queue.isEmpty()) {
            curr = queue.poll();
            if (nextLevelStartNode != null && nextLevelStartNode == curr) {
                valsOfLevel = new ArrayList<>();
                res.add(valsOfLevel);
                nextLevelStartNode = null;
            }
            valsOfLevel.add(curr.val);
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
            nextLevelStartNode = nextLevelStartNode == null ? curr.left != null ? curr.left : curr.right : nextLevelStartNode;
        }
        return res;
    }

    @Test
    public void test1() {
        TreeNode root = new TreeNode(3);
        TreeNode rLeft = new TreeNode(9);
        TreeNode rRight = new TreeNode(20);
        root.left = rLeft;
        root.right = rRight;
        rRight.left = new TreeNode(15);
        rRight.right = new TreeNode(7);
        List<List<Integer>> res = levelOrder(root);
        print(res);

    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(1);
        TreeNode rLeft = new TreeNode(2);
        TreeNode rRight = new TreeNode(3);
        root.left = rLeft;
        root.right = rRight;
        rLeft.left = new TreeNode(4);
        rLeft.right = new TreeNode(5);
        List<List<Integer>> res = levelOrder(root);
        print(res);

    }

    public void print(List<List<Integer>> res){
        Iterator<List<Integer>> levelIterator = res.iterator();
        System.out.println("[");
        while (levelIterator.hasNext()) {
            Iterator<Integer> vals = levelIterator.next().iterator();
            System.out.print("[");
            while (vals.hasNext()) {
                System.out.print(vals.next());
                if (vals.hasNext()) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            if (levelIterator.hasNext()) {
                System.out.print(",");
            }
            System.out.println();
        }
        System.out.println("]");
    }
}
