package leetcode.binarysearch;

import org.junit.Test;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/6 - 09:31
 * @description: 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;

        int left = 0, right = nums.length - 1;
        int middle;
        int rotateIndex = nums[0] > nums[1] ? 0 : nums.length - 1;
        while (left < right) {
            middle = (left + right) / 2;
            if (nums[middle] > nums[middle + 1]) {
                rotateIndex = middle;
                break;
            }
            if (nums[middle] > nums[0]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        if (nums[0] <= target) {
            return search(nums, target, 0, rotateIndex);
        } else {
            return search(nums, target, rotateIndex + 1, nums.length - 1);
        }

    }


    public int search(int[] nums, int target, int left, int right) {
        int middle;
        while (left <= right) {
            middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }


    /**
     * 第二中方式
     */
    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        int left = 0;
        int right = nums.length - 1;
        int middle;
        while (left <= right) {
            middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[0] <= nums[middle]) {
                if (target >= nums[0] && target < nums[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {//nums[0] > nums[middle]
                if (target >= nums[0] || target < nums[middle]) {
                    right = middle - 1;
                } else if (target < nums[0] && target > nums[middle]) {
                    left = middle + 1;
                }
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums, 0));
        System.out.println(search2(nums, 0));
    }


    @Test
    public void test1() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums, 3));
        System.out.println(search2(nums, 3));
    }

    @Test
    public void test2() {
        int[] nums = {1};
        System.out.println(search(nums, 1));
        System.out.println(search2(nums, 1));
    }

    @Test
    public void test3() {
        int[] nums = {1, 3};
        System.out.println(search(nums, 1));
        System.out.println(search2(nums, 1));
    }

    @Test
    public void test7() {
        int[] nums = {1, 3};
        System.out.println(search(nums, 3));
        System.out.println(search2(nums, 3));
    }

    @Test
    public void test4() {
        int[] nums = {3, 5, 1};
        System.out.println(search(nums, 3));
        System.out.println(search2(nums, 3));
    }

    @Test
    public void test5() {
        int[] nums = {1, 3, 5};
        System.out.println(search(nums, 1));
        System.out.println(search2(nums, 1));
    }

    @Test
    public void test6() {
        int[] nums = {4, 5, 1, 2, 3};
        System.out.println(search(nums, 2));
        System.out.println(search2(nums, 2));
    }
}
