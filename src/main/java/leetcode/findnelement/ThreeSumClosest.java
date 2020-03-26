package leetcode.findnelement;

import java.util.Arrays;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/2/13 - 08:43
 * @description: 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 */
public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int ret = nums[0] + nums[1] + nums[2];
        int sum;
        for (int i = 0; i < nums.length -2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {

                sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(sum - target) < Math.abs(ret - target)) {
                    ret = sum;
                }
                if (sum > target) {
                    r--;
                } else if (sum < target) {
                    l++;
                } else {
                    return ret;
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int ans = threeSumClosest(nums, 1);
        System.out.println(ans);
    }

}
