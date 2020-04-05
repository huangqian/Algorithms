package leetcode.sort;

import leetcode.PrintKit;
import org.junit.Test;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/4/4 - 22:26
 * @description: 88. 合并两个有序数组
 * <pre>
 *   给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
 *
 *  
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * </pre>
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        int p1, p2, cp2;
        p1 = 0;
        cp2 = p2 = 0;
        int len1 = m;
        while (len1 < m + n) {

            while (p1 < len1 && (p2 >= n || nums1[p1] <= nums2[p2])) p1++;
            while (p2 < n && (p1 >= len1 || nums1[p1] >= nums2[p2])) p2++;
            if (p2 > cp2) {
                //计算需要给nums2准备的空间
                int moveSpace = p2 - cp2;
                //注意从后往前移动
                for (int i = len1 - 1; i >= p1; i--) {
                    nums1[i + moveSpace] = nums1[i];
                }
                //将nums2数组复制过去
                for (int j = p1; j < p1 + moveSpace; j++) {
                    nums1[j] = nums2[cp2++];
                }
                p1 += moveSpace;
                len1 += moveSpace;
            }
        }
    }

    @Test
    public void test1() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);
        PrintKit.print(nums1);
    }

    @Test
    public void test2() {
        int[] nums1 = {2, 0};
        int m = 1;
        int[] nums2 = {1};
        int n = 1;
        merge(nums1, m, nums2, n);
        PrintKit.print(nums1);
    }

    @Test
    public void test3() {
        int[] nums1 = {4, 0, 0, 0, 0, 0};
        int m = 1;
        int[] nums2 = {1, 2, 3, 5, 6};
        int n = 5;
        merge(nums1, m, nums2, n);
        PrintKit.print(nums1);
    }
}
