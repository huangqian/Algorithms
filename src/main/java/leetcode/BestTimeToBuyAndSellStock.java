package leetcode;

import org.junit.Test;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/9 - 23:27
 * @description: 121. 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意你不能在买入股票前卖出股票。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 */
public class BestTimeToBuyAndSellStock {

    /**
     * 通过动态规划来做，用一个数组存储在档期节点前的最低单价
     */
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int[] minPrices = new int[prices.length];
        minPrices[0] = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            minPrices[i] = Math.min(minPrices[i - 1], prices[i - 1]);
            profit = Math.max(profit, (prices[i] - minPrices[i]));
        }
        return profit;
    }


    @Test
    public void test1() {
        int[] nums = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(nums));
    }

    @Test
    public void test2() {
        int[] nums = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(nums));
    }
}
