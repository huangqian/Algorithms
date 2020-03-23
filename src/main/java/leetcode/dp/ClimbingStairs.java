package leetcode.dp;

import org.junit.Test;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/20 - 11:16
 * @description: 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class ClimbingStairs {

    /**
     * 解题思路：
     * 动态规划
     * 使用数组f[k]表示到第k阶梯有几种方法
     */
    public int climbStairs(int n) {
        if (n < 2) return n;
        int[] f = new int[n];
        f[0] = 1;
        f[1] = 2;
        for (int k = 2; k < n; k++) {
            f[k] = f[k - 2] + f[k - 1];
        }
        return f[n - 1];
    }


    @Test
    public void test() {
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
        System.out.println(climbStairs(10));
        System.out.println(climbStairs(20));
    }


}
