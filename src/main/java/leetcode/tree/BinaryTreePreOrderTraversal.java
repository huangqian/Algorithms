package leetcode.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/23 - 09:14
 * @description: 144. 二叉树的前序遍历
 * <pre>
 *  给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * </pre>
 */
public class BinaryTreePreOrderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode curr;
        while (!stack.isEmpty()) {
            curr = stack.pop();
            list.add(curr.val);
            if (curr.right != null) stack.add(curr.right);
            if (curr.left != null) stack.add(curr.left);
        }
        return list;
    }

    @Test
    public void test1() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> list = preorderTraversal(root);
        print(list);
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(1);
        TreeNode l1Left = new TreeNode(4);
        TreeNode l2Left = new TreeNode(3);
        root.left = l1Left;
        l1Left.left = l2Left;
        root.right = new TreeNode(2);
        List<Integer> list = preorderTraversal(root);
        print(list);
    }

    public void print(List<Integer> list) {
        Iterator<Integer> iter = list.iterator();
        System.out.print("[");
        while (iter.hasNext()) {
            System.out.print(iter.next());
            if (iter.hasNext()) {
                System.out.print(",");
            }
        }
        System.out.print("]");

    }

}
