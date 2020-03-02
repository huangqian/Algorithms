package leetcode.array;

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
        int mediaIndex = (len1 + len2) / 2;


        return 0;
    }

}
