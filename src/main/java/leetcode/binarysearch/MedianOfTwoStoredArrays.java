package leetcode.binarysearch;

import org.junit.Test;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/2/25 - 15:07
 * @description: 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 */
public class MedianOfTwoStoredArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1 == null ? 0 : nums1.length;
        int len2 = nums2 == null ? 0 : nums2.length;

        if ((len1 + len2) % 2 != 0) {
            return getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, (len1 + len2) / 2 + 1);
        } else {
            return 0.5d * getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, (len1 + len2) / 2)
                    + 0.5d * getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, (len1 + len2) / 2 + 1);
        }

    }

    public int getKth(int[] nums1, int left1, int right1, int[] nums2, int left2, int right2, int k) {

        int length1 = right1 - left1 + 1;
        int length2 = right2 - left2 + 1;
        //永远处理小的数组
        if (length1 > length2) return getKth(nums2, left2, right2, nums1, left1, right2, k);
        if (k == 1) return Math.min(nums1[left1], nums2[left2]);

        if (length1 == 0) return nums2[left2 + k - 1];

        int middle1 = left1 + Math.min(k / 2, length1) - 1;
        int middle2 = left2 + Math.min(k / 2, length2) - 1;
        if (nums1[middle1] > nums2[middle2]) {
            return getKth(nums1, left1, right1, nums2, middle2 + 1, right2, k - (middle2 - left2 + 1));
        } else {
            return getKth(nums1, middle1 + 1, right1, nums2, left2, right2, k - (middle1 - left1 + 1));
        }
    }

    @Test
    public void test() {
        int[] num1 = {1, 3};
        int[] num2 = {2};
        System.out.println(findMedianSortedArrays(num1, num2));
    }

    @Test
    public void test2() {
        int[] num1 = {1, 2};
        int[] num2 = {3, 4};
        System.out.println(findMedianSortedArrays(num1, num2));
    }

}
