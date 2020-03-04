package leetcode.linkedlist;

import java.util.HashMap;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/3 - 23:53
 * @description:
 */
public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public String toString() {
        return "[" + val + "," + (random == null ? "null" : random.val) + "]";
    }

    public void print() {
        StringBuilder sb = new StringBuilder("[").append(this.toString());
        Node cur = this.next;
        while (cur != null) {
            sb.append(",").append(cur.toString());
            cur = cur.next;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static Node of(Integer[][] nodes) {
        if (nodes == null || nodes.length == 0) {
            return null;
        }
        Node dummy = new Node(0);
        Node cur = dummy;
        Node node;
        HashMap<Integer, Node> sequenceOfNode = new HashMap<>();
        for (int i = 0; i < nodes.length; i++) {
            node = new Node(nodes[i][0]);
            cur.next = node;
            sequenceOfNode.put(i, node);
            cur = cur.next;
        }
        //构建random指针
        cur = dummy.next;
        for (int k = 0; cur != null; k++, cur = cur.next) {
            cur.random = sequenceOfNode.get(nodes[k][1]);
        }
        return dummy.next;
    }
}
