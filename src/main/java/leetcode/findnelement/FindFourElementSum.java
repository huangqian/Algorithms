package leetcode.findnelement;

import leetcode.PrintKit;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/23 - 23:03
 * @description: <pre>
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 * </pre>
 */
public class FindFourElementSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int l, r;
        int sum;
        for (int n = 0; n < nums.length - 3; n++) {
            //去重第一大的相同数子
            if (n > 0 && nums[n] == nums[n - 1]) continue;
            for (int m = n + 1; m < nums.length - 2; m++) {
                //去重第二大的相同数子
                if (m > n + 1 && nums[m] == nums[m - 1]) continue;
                l = m + 1;
                r = nums.length - 1;
                while (l < r) {
                    sum = nums[n] + nums[m] + nums[l] + nums[r];
                    if (sum > target) {
                        r--;
                    } else if (sum < target) {
                        l++;
                    } else {//符合条件的
                        res.add(Arrays.asList(nums[n], nums[m], nums[l], nums[r]));
                        //去重第三大的相同数子
                        while (l < r && nums[l + 1] == nums[l]) {
                            l++;
                        }
                        while (l < r && nums[r - 1] == nums[r]) {
                            r--;
                        }
                        l++;
                        r--;
                    }
                }
            }
        }
        return res;
    }


    public List<List<Integer>> fourSum1(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int l, r;
        int sum;
        for (int n = 0; n < nums.length - 3; n++) {
            //去重第一大的相同数子
            if (n > 0 && nums[n] == nums[n - 1]) continue;
            for (int m = n + 1; m < nums.length - 2; m++) {
                //去重第二大的相同数子
                if (m > n + 1 && nums[m] == nums[m - 1]) continue;
                l = m + 1;
                r = nums.length - 1;
                while (l < r) {
                    sum = nums[n] + nums[m] + nums[l] + nums[r];
                    if (sum > target) {
                        r--;
                    } else if (sum < target) {
                        l++;
                    } else {//符合条件的
                        res.add(Arrays.asList(nums[n], nums[m], nums[l], nums[r]));
                        //去重第三大的相同数子
                        while (l < r && nums[l] == nums[++l]) ;
                        while (l < r && nums[r] == nums[--r]) ;
                    }
                }
            }
        }
        return res;
    }


    @Test
    public void test2() {
        int[] nums = {-3, -2, -1, 0, 0, 1, 2, 3};
        List<List<Integer>> list = fourSum(nums, 0);
        PrintKit.print(list);
    }

    @Test
    public void test1() {
        int[] nums = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> list = fourSum(nums, 0);
        PrintKit.print(list);
    }
}
