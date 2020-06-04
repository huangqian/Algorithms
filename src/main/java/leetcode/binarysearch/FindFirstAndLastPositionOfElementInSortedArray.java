package leetcode.binarysearch;

import leetcode.PrintKit;
import org.junit.Test;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/6/3 - 16:52
 * @description: 在排序的数组中查找元素的第一个和最后一个位置
 *
 * <pre>
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * </pre>
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};

        int left = 0;
        int right = nums.length - 1;
        int middle;
        int max = -1, min = -1;
        while (left <= right) {
            middle = (left + right) / 2;
            if (nums[middle] == target) {
                max = max == -1 ? middle : Math.max(max, middle);
                min = min == -1 ? middle : Math.min(min, middle);
                while (max < right) {
                    middle = (max + right + 1) / 2;
                    if (middle > max && nums[middle] == target) {
                        max = middle;
                    } else {
                        right = middle - 1;
                    }
                }
                right--;
                while (left < min) {
                    middle = (left + min) / 2;
                    if (middle < min && nums[middle] == target) {
                        min = middle;
                    } else {
                        left = middle + 1;
                    }
                }
                left++;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }


        return new int[]{min, max};

    }

    @Test
    public void test01() {
        int[] nums = {1, 2, 3};
        int[] ans = searchRange(nums, 4);
        PrintKit.print(ans);
    }

    @Test
    public void test02() {
        int[] nums = {1, 2, 3};
        int[] ans = searchRange(nums, 2);
        PrintKit.print(ans);
    }

    @Test
    public void test03() {
        int[] nums = {1, 1, 3};
        int[] ans = searchRange(nums, 1);
        PrintKit.print(ans);
    }


    @Test
    public void test04() {
        int[] nums = {1, 2, 2};
        int[] ans = searchRange(nums, 2);
        PrintKit.print(ans);
    }

    @Test
    public void test05() {
        int[] nums = {1, 2, 2, 4, 4, 4, 4, 4};
        int[] ans = searchRange(nums, 4);
        PrintKit.print(ans);
    }

}
