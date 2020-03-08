package leetcode.array;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/8 - 00:03
 * @description: 最大子序和
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 */
public class MaximumSubArray {

    /**
     * 贪心算法实现
     * 原理是：
     * 1. sum和sum+当前节点的数据最大值作为sum
     * 2. 比较max为max和sum之间的最大值
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(max, sum);
        }
        return max;
    }

    /**
     * 动态规划实现
     *
     * 状态为
     * f(n):
     *    if num[n-1] > 0 : fn[n] = fn[n-1] + nums[n]
     *    if num[n-1] < 0 : fn[n] = nums[n]
     * 换句话说fn代表是当前节点之前的最大子数组的累计值
     * 原理：
     *   为当前最大值max
     *   if(nums[n-1] > 0) nums[n]= nums[n] + nums[n-1]
     *   max= max(max, nums[n])
     */
    public int maxSubArrayByDP(int[] nums) {
        if (nums.length == 1) return nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) nums[i] += nums[i - 1];
            max = Math.max(nums[i], max);
        }
        return max;
    }
}
