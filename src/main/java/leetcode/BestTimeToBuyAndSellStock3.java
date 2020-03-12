package leetcode;

import org.junit.Test;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/10 - 15:23
 * @description: 123. 买卖股票的最佳时机 III
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
 */
public class BestTimeToBuyAndSellStock3 {

    //思路：找一个分界点，左边的最大+右边的最大收益的组合最大值
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int profit = 0;
        int leftMax;
        int rightMax;
        for (int i = 1; i < prices.length; i++) {
            leftMax = maxProfitOfOnceTransaction(prices, 0, i);
            rightMax = maxProfitOfOnceTransaction(prices, i + 1, prices.length - 1);
            profit = Math.max(profit, leftMax + rightMax);
        }
        return profit;
    }

    public int maxProfitOfOnceTransaction(int[] prices, int start, int end) {
        if (end <= 0 || start >= prices.length - 1 || end - start < 1) return 0;
        int[] minPrice = new int[end - start + 1];
        minPrice[0] = prices[start];
        int profit = 0;
        for (int k = start + 1; k <= end; k++) {
            minPrice[k - start] = Math.min(minPrice[k - start - 1], prices[k]);
            profit = Math.max(profit, prices[k] - minPrice[k-start]);
        }
        return profit;
    }

    @Test
    public void test() {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(prices));
    }

    @Test
    public void test1() {
        int[] prices = {1, 2, 3, 4, 5};
        System.out.println(maxProfitOfOnceTransaction(prices, 0, 4));
    }
}
