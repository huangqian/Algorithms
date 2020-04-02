package leetcode.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/4/2 - 17:27
 * @description: 322. 零钱兑换
 * <pre>
 *  给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * </pre>
 */
public class CoinChange {

    /**
     * 题解思路：动态规划。和爬楼梯的相似
     * dp[n]标识金额为n的最少硬币个数。
     * dp[n] = min(dp[n-coins[1]],dp[n-coins[2]],...,dp[n-coins[j]])
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    @Test
    public void test1() {
        int[] coins = {1, 2, 5};
        System.out.println(coinChange(coins, 11));
    }
}
