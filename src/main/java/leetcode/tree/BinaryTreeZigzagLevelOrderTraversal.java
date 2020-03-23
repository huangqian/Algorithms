package leetcode.tree;

import leetcode.PrintKit;
import org.junit.Test;

import java.util.*;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/23 - 09:41
 * @description: XXXX
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> traversalQueue = new LinkedList<>();
        Queue<TreeNode> outQueue = new LinkedList<>();
        traversalQueue.add(root);
        int level = 0;
        List<Integer> vals;
        TreeNode curr;
        while (!traversalQueue.isEmpty()) {

            if (level % 2 == 0) {
                while (!traversalQueue.isEmpty()) outQueue.add(traversalQueue.poll());
                vals = new ArrayList<>(outQueue.size());
                res.add(vals);
                while (!outQueue.isEmpty()) {
                    curr = outQueue.poll();
                    vals.add(curr.val);
                    if (curr.left != null) traversalQueue.add(curr.left);
                    if (curr.right != null) traversalQueue.add(curr.right);
                }
            } else {
                while (!traversalQueue.isEmpty()) {
                    curr = traversalQueue.poll();
                    stack.push(curr);
                    outQueue.add(curr);
                }
                vals = new ArrayList<>(stack.size());
                res.add(vals);
                while (!stack.isEmpty()) vals.add(stack.pop().val);
                while (!outQueue.isEmpty()) {
                    curr = outQueue.poll();
                    if (curr.left != null) traversalQueue.add(curr.left);
                    if (curr.right != null) traversalQueue.add(curr.right);
                }

            }

            level++;
        }

        return res;

    }

    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        LinkedList<TreeNode> queue = new LinkedList<>();


        return res;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        TreeNode val9 = new TreeNode(9);
        root.left = val9;
        TreeNode val20 = new TreeNode(20);
        root.right = val20;
        TreeNode val15 = new TreeNode(15);
        val20.left = val15;
        TreeNode val7 = new TreeNode(7);
        val20.right = val7;
        List<List<Integer>> list = zigzagLevelOrder(root);
        PrintKit.print(list);
    }


}
