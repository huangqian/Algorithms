package leetcode.unionfind;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/4/1 - 23:31
 * @description: 128. 最长连续序列
 * <pre>
 *  给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * </pre>
 */
public class LongestConsecutiveSequence {

    class UnionFind {
        int max;
        HashMap<Integer, Integer> roots;
        HashMap<Integer, Integer> sizeMap;

        public UnionFind(int[] nums) {
            max = 1;
            roots = new HashMap<>();
            sizeMap = new HashMap<>();
            for (int n : nums) {
                roots.put(n, n);
                sizeMap.put(n, 1);
            }
        }

        public int find(int i) {
            if (roots.get(i) != i)
                roots.put(i, find(roots.get(i)));
            return roots.get(i);
        }

        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                int xSize = sizeMap.get(rootx);
                int ySize = sizeMap.get(rooty);
                if (xSize >= ySize) {
                    roots.put(rooty, rootx);
                    sizeMap.put(rootx, xSize + ySize);
                } else {
                    roots.put(rootx, rooty);
                    sizeMap.put(rooty, xSize + ySize);
                }
                max = Math.max(max, xSize + ySize);
            }
        }

        public int getMax() {
            return max;
        }
    }

    /**
     * 题解思路： 使用并查集
     * 1. 对数组遍历，下标索引为i，通过并查集查找nums[i] - 1是否存在，如果存在nums[i]和nums[i] - 1合并。
     * 1. 对数组遍历，下标索引为i，通过并查集查找nums[i] + 1是否存在，如果存在nums[i]和nums[i] + 1合并。
     */
    public int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        UnionFind uf = new UnionFind(nums);
        for (int n : nums) {
            if (uf.roots.containsKey(n - 1)) {
                uf.union(n - 1, n);
            }
            if (uf.roots.containsKey(n + 1)) {
                uf.union(n + 1, n);
            }
        }
        return uf.getMax();
    }

    @Test
    public void test1() {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }
}
