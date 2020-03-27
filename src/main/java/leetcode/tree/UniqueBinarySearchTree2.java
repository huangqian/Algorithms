package leetcode.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/27 - 00:01
 * @description: 95. 不同的二叉搜索树 II
 * <pre>
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
 * </pre>
 */
public class UniqueBinarySearchTree2 {

    /**
     * 解题思路：回溯算法
     * 对该题目其实就是对于1到n分别作为根节点，然后剩余的节点分别作为按照此规则建立左子树和右子树
     */
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) return new ArrayList<>();
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();
        if (end < start) {
            trees.add(null);
            return trees;
        }

        TreeNode curr;
        for (int i = start; i <= end; i++) {

            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    curr = new TreeNode(i);
                    curr.left = leftTree;
                    curr.right = rightTree;
                    trees.add(curr);
                }
            }
        }

        return trees;
    }

    @Test
    public void test() {
        List<TreeNode> res = generateTrees(3);
        System.out.println(res);

    }
}
