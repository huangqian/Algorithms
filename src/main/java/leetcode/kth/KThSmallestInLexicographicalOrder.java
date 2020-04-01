package leetcode.kth;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/21 - 22:19
 * @description: 440. 字典序的第K小数字
 *
 * <p>
 * 给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。
 * <p>
 * 注意：1 ≤ k ≤ n ≤ 109。
 * <p>
 * 示例 :
 * <p>
 * 输入:
 * n: 13   k: 2
 * <p>
 * 输出:
 * 10
 * <p>
 * 解释:
 * 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order
 * </p>
 */
public class KThSmallestInLexicographicalOrder {

    public int findKthNumber(int n, int k) {

        int prefix = 1;
        int p = 1;
        while (p < k) {
            int count = getCount(prefix, n);
            if (p + count > k) {
                prefix *= 10;
                p++;
            } else if (p + count <= k) {
                prefix++;
                p += count;
            }
        }
        return prefix;
    }

    public int getCount(int prefix, int n) {
        long cur = prefix;
        long next = prefix + 1;
        int count = 0;
        while (cur <= n) {
            count += Math.min(n + 1, next) - cur;
            cur *= 10;
            next *= 10;
        }
        return count;
    }


    @Test
    public void test() {

        PriorityQueue<String> priorityQueue = new PriorityQueue<String>(30, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.compareTo(s1);
            }
        });
        priorityQueue.add("111");
        priorityQueue.add("121");
        priorityQueue.add("2");
        priorityQueue.add("1");
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
    }

    @Test
    public void test1() {
        System.out.println(findKthNumber(13, 2));
    }

    @Test
    public void test2() {
        System.out.println(findKthNumber(1692778, 1545580));
    }
}
