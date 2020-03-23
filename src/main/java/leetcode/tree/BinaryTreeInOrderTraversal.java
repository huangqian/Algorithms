package leetcode.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/22 - 22:07
 * @description: 94. 二叉树的中序遍历
 * <pre>
 *
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 */
public class BinaryTreeInOrderTraversal {

    /**
     * 由于不能使用递归，这里使用的二叉链表构建的二叉树，必须需要通过一个数据结构记录父节点和兄弟节点。
     * 这里的思路采用栈来记录
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }


    public List<Integer> inOrderTraversalByRecursive(TreeNode root) {
        List<Integer> traversalRecord = new ArrayList<>();
        inOrderTraversalByRecursive(root, traversalRecord);
        return traversalRecord;
    }

    public void inOrderTraversalByRecursive(TreeNode node, List<Integer> traversalRecord) {
        if (node == null) return;
        inorderTraversal(node.left);
        traversalRecord.add(node.val);
        inorderTraversal(node.right);
    }

    @Test
    public void test1() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> list = inorderTraversal(root);
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
