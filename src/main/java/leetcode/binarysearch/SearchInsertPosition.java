package leetcode.binarysearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/6/11 - 10:33
 * @description: 35. 搜索插入位置
 * <pre>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * </pre>
 */
public class SearchInsertPosition {

    /**
     * 题解思路：
     * 二分查找。左边和右边两个指针，当指针收拢以后要么找到，要么就是插入，收拢后插入就是在middle和middle的前一个位置。
     * 当收拢的时候 nums[middle] > target，这个时候的插入位置就是middle。因为nums[middle-1] > target
     */

    public int searchInsert(int[] nums, int target) {

        if (nums.length == 0 || nums[0] > target) return 0;
        if (nums[nums.length - 1] < target) return nums.length;
        int left = 0;
        int right = nums.length - 1;
        int middle = left;
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
        return nums[middle] < target ? middle + 1 : middle;
    }

    @Test
    public void test01() {
        int[] nums = {1, 3, 5, 6};
        printWithAssertEquals(searchInsert(nums, 5), 2);

        printWithAssertEquals(searchInsert(nums, 2), 1);
    }

    @Test
    public void test02() {
        int[] nums = {1, 3, 5, 6};
        printWithAssertEquals(searchInsert(nums, 7), 4);

        printWithAssertEquals(searchInsert(nums, 0), 0);
    }

    @Test
    public void test03() {
        int[] nums = {1, 3};
        printWithAssertEquals(searchInsert(nums, 2), 1);
    }

    @Test
    public void test04() {
        int[] nums = {1, 3, 5, 6};
        printWithAssertEquals(searchInsert(nums, 2), 1);
    }

    public static void printWithAssertEquals(int t1, int t2) {
        assertEquals(t1, t2);
        System.out.println(t1);
    }
}
