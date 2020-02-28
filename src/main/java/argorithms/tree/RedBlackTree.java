package argorithms.tree;

import com.sun.org.apache.regexp.internal.RE;

import static argorithms.tree.RedBlackTree.Color.BLACK;
import static argorithms.tree.RedBlackTree.Color.RED;

/**
 * 红黑树
 */
public class RedBlackTree<T extends Comparable<T>> {


    /**
     * 根节点
     */
    private RedBlackNode<T> root;


    public RedBlackTree() {
        this.root = new RedBlackNode<T>();
    }

    /**
     * 红黑树节点
     */
    static class RedBlackNode<T extends Comparable<T>> {

        /**
         * 排序的key
         */
        private T key;

        /**
         * 节点的颜色
         */
        private Color color;


        /**
         * 左孩子节点
         */
        private RedBlackNode<T> left;

        /**
         * 右孩子
         */
        private RedBlackNode<T> right;

        /**
         * 父节点
         */
        private RedBlackNode<T> parent;

        public RedBlackNode(Color color, RedBlackNode<T> left, RedBlackNode<T> right, RedBlackNode<T> parent) {
            this.color = color;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        public RedBlackNode(T key) {
            this(BLACK, null, null, null);
            this.key = key;
        }

        public RedBlackNode() {
            this(null);
        }
    }

    static enum Color {
        BLACK, RED;
    }


    /**
     * 红黑树的左旋
     *
     * @param x
     */
    public void leftRotate(RedBlackNode<T> x) {

        RedBlackNode<T> y = x.right;
        x.right = y.left;
        y.left.parent = x;
        y.parent = x.parent;

        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }

        y.left = x;
        x.parent = y;
    }


    /**
     * 围绕节点X右旋
     *
     * @param x
     */
    public void rightRotate(RedBlackNode<T> x) {

        RedBlackNode<T> y = x.left;
        x.left = y.right;
        y.parent = x.parent;

        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }

        y.right = x;
        x.parent = y;
    }

    public void insert(RedBlackNode<T> node) {

        if (node == null) {
            throw new NullPointerException("inserted node must be not null");
        }

        RedBlackNode<T> y = null;
        RedBlackNode<T> current = this.root;

        while (current != null) {
            y = current;
            if (node.key.compareTo(current.key) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        node.parent = y;
        if (y == null) {
            this.root = node;

        } else if (node.key.compareTo(y.key) < 0) {
            y.left = node;

        } else {
            y.right = node;
        }

        node.left = null;
        node.right = null;
        node.color = RED;
    }

    public void insertFixup(RedBlackNode<T> z){

        while(z.color == RED){

            if(z.parent == z.parent.parent.left){
                RedBlackNode<T> y = z.parent.parent.right;
                if(y.color == RED){
                    z.parent.color = BLACK;
                    y.color = BLACK;
                    z.parent.parent.color = RED;
                    z = z.parent.parent;
                }else if (z == z.parent.right){
                    z = z.parent;
                    leftRotate(z);
                    z.parent.color = BLACK;
                    z.parent.parent.color = RED;
                    rightRotate(z.parent.parent);
                }
            }
        }

    }

}
