package leetcode.interview.bytedance;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/23 - 22:51
 * @description: <pre>
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 *
 * 示例 1:
 *
 * 输入: [1,4,3,2]
 *
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 * 提示:
 *
 * n 是正整数,范围在 [1, 10000].
 * 数组中的元素范围在 [-10000, 10000].
 * </pre>
 */
public class MaxArrayPairSum {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int[] f = new int[nums.length / 2];
        f[0] = nums[0];
        for (int i = 1; i < nums.length / 2; i++) {
            f[i] = f[i - 1] + nums[i * 2];
        }

        return f[nums.length / 2 - 1];
    }

    @Test
    public void test() {
        int[] nums = {1, 4, 3, 2};
        System.out.println(arrayPairSum(nums));
    }
}
