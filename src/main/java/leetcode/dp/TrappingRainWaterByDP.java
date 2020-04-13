package leetcode.dp;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/4/13 - 00:09
 * @description: 42. 接雨水
 *
 * <pre>
 *  给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 */
public class TrappingRainWaterByDP {

    /**
     * <pre>
     * 题解思路：动态规划
     *
     * 对于任意一个位置，其存水量是由其左边的最高的墙和右边最高的决定的。trap = min(maxLeft, maxRight) - current;
     *
     * 1. 定义状态： 因此，我们可以设定两个数组maxLefts[n]、maxRight[n]分别表示坐标为n的左边和右边的最高值
     *
     * 2. 状态转移方程：
     *      maxLefts[n] = max(height[n-1], maxLefts[n-1])
     *      maxRights[n] = max(height[n+1], maxRight[n+1])
     * 3. 计算答案
     *    for i in 1...n
     *        count += max(min(maxLefts[n], maxRights[n]) - height[n], 0);
     *
     * </pre>
     */
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        int n = height.length;
        int[] maxLefts = new int[n];
        maxLefts[0] = 0;
        int[] maxRights = new int[n];
        maxRights[n - 1] = 0;
        //从左到右边扫描一遍，找出左边最大值
        for (int i = 1; i < n; i++) maxLefts[i] = Math.max(height[i - 1], maxLefts[i - 1]);
        //从右边到左扫描一遍，找出右边的最大值
        for (int k = n - 2; k >= 0; k--) maxRights[k] = Math.max(height[k + 1], maxRights[k + 1]);
        int capacity = 0;
        for (int j = 1; j < n - 1; j++) {
            capacity += Math.max(Math.min(maxLefts[j], maxRights[j]) - height[j], 0);
        }
        return capacity;
    }
}
