package leetcode.findnelement;

import leetcode.PrintKit;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/5/3 - 21:45
 * @description: <pre>
 *
 *  给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * </pre>
 */
public class ThreeElementSumEqualsZero {

    /**
     * 题解思路：
     * <pre>
     *  使用HashMap对数据建立索引，对于任意两个数据之和相反数作为key去HashMap中检索，如果存在这样的一个数，则表示存在三个数之和为0，
     * </pre>
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) return ans;

        //将数组排序
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(-n, n);
        }
        int sum;
        for (int i = 0; i < nums.length - 2; i++) {
            //去除第一个元素相同的结果。
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 1; j++) {
                //去除第二个元素相同的结果
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                sum = nums[i] + nums[j];
                // map.get(-sum) > nums[j]避免第三个元素在之前出现的过的情况
                if (map.containsKey(sum) && (map.get(sum) > nums[j] || map.get(sum) == nums[j + 1])) {
                    ans.add(Arrays.asList(nums[i], nums[j], map.get(sum)));
                }
            }
        }
        return ans;
    }

    @Test
    public void test01() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ans = threeSum(nums);
        PrintKit.print(ans);
    }

    @Test
    public void test02() {
        int[] nums = {0, 0, 0};
        List<List<Integer>> ans = threeSum(nums);
        PrintKit.print(ans);
    }
}
