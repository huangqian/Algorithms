package leetcode.linkedlist;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/3 - 22:40
 * @description: 复制带随机指针的链表
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 要求返回这个链表的 深拷贝。 
 * <p>
 * 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * <p>
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 示例 4：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 *  
 * <p>
 * 提示：
 * <p>
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
 */
public class CopyListWithRandomPointer {


    public Node copyRandomList(Node head) {
        if (head == null) return null;
        HashMap<Integer, Node> srcRandomPointerIndex = new HashMap<>();
        HashMap<Node, Integer> srcNodeToNumberIndex = new HashMap<>();
        Node cur = head;
        Node copiesHead = new Node(-1);
        Node copies;
        Node copiesPre = copiesHead;
        HashMap<Node, Integer> copiedNodeToSequence = new HashMap<>();
        HashMap<Integer, Node> sequenceOfCopiesNode = new HashMap<>();
        int i = 0;
        for (; cur != null; cur = cur.next, i++) {
            copies = new Node(cur.val);
            copiesPre.next = copies;
            copiesPre = copiesPre.next;
            srcRandomPointerIndex.put(i, cur.random);
            srcNodeToNumberIndex.put(cur, i);

            copiedNodeToSequence.put(copies, i);
            sequenceOfCopiesNode.put(i, copies);
        }
        HashMap<Integer, Integer> randomPointerImage = new HashMap<>();
        for (Map.Entry<Integer, Node> rndEntry : srcRandomPointerIndex.entrySet()) {
            randomPointerImage.put(rndEntry.getKey(), srcNodeToNumberIndex.get(rndEntry.getValue()));
        }

        for (int k = 0; k < i; k++) {
            sequenceOfCopiesNode.get(k).random = sequenceOfCopiesNode.get(randomPointerImage.get(k));
        }

        return copiesHead.next;
    }


    @Test
    public void test1() {
        Integer[][] elements = {{7, null}, {13, 0}, {11, 4}, {10, 2}, {1, 0}};
        Node head = copyRandomList(Node.of(elements));
        head.print();

    }
}
