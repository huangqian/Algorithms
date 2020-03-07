package argorithms.tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/6 - 21:49
 * @description: 二叉树的遍历方式
 */
public class BinaryTreeTravers {

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }


        @Override
        public String toString() {
            return "val=" + val + ", left" + (left == null ? "null" : left.val) + ", right=" + (right == null ? "null" : right.val);
        }
    }

    /**
     * 前序遍历打印
     * 当前节点->左子节点->右子节点
     */
    public void preOrderPrint(Node root) {
        if (root == null) return;
        System.out.println(root.val);
        preOrderPrint(root.left);
        preOrderPrint(root.right);
    }

    /**
     * 中序遍历打印
     * 左子节点->当前节点->右子节点
     */
    public void inOrderPrint(Node root) {
        if (root == null) return;
        inOrderPrint(root.left);
        System.out.println(root.val);
        inOrderPrint(root.right);

    }

    /**
     * 后序遍历打印
     */
    public void postOrderPrint(Node root) {
        if (root == null) return;
        postOrderPrint(root.left);
        postOrderPrint(root.right);
        System.out.println(root.val);
    }

    /**
     * 层序遍历
     */
    public void levelOrderPrint(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        Node cur;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur == null) continue;
            System.out.printf("%d ", cur.val);
            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
        }

    }

    @Test
    public void testPreOrderPrint() {
        Node root = new Node(3);
        Node left = new Node(2);
        root.left = left;
        Node right = new Node(7);
        root.right = right;
        preOrderPrint(root);
    }

    @Test
    public void testInOrderPrint() {
        Node root = new Node(3);
        Node left = new Node(2);
        root.left = left;
        Node right = new Node(7);
        root.right = right;
        inOrderPrint(root);
    }

    @Test
    public void testPostOrderPrint() {
        Node root = new Node(3);
        Node left = new Node(2);
        root.left = left;
        Node right = new Node(7);
        root.right = right;
        postOrderPrint(root);
    }

    @Test
    public void testLevelOrderPrint() {
        /*      3
         *   2     7
         * 0  1  6  8
         */

        Node root = new Node(3);
        Node left = new Node(2);
        root.left = left;
        Node ll2 = new Node(0);
        left.left = ll2;
        Node lr2 = new Node(1);
        left.right = lr2;
        Node right = new Node(7);
        root.right = right;
        Node rl2 = new Node(6);
        right.left = rl2;
        Node rr2 = new Node(8);
        right.right = rr2;
        levelOrderPrint(root);
    }
}
