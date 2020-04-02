package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/4/2 - 16:21
 * @description: 31. 下一个排列
 * <pre>
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums.length < 2) return;
        int t;
        int firstIndex;
        for (int i = nums.length - 1; i >= 0; i--) {
            firstIndex = indexOfFirstGT(nums, i, i + 1);
            if (firstIndex != -1) {
                t = nums[firstIndex];
                nums[firstIndex] = nums[i];
                nums[i] = t;
                Arrays.sort(nums, i + 1, nums.length);
                return;
            }
        }
        Arrays.sort(nums);
    }

    public int indexOfFirstGT(int[] nums, int k, int offset) {
        int index = -1;
        for (int i = offset; i < nums.length; i++) {
            if (nums[i] > nums[k] && (index == -1 || nums[i] < nums[index])) {
                index = i;
            }
        }
        return index == k ? -1 : index;
    }


    @Test
    public void test1() {
        int[] nums = {1, 2, 3};
        nextPermutation(nums);
        PrintKit.print(nums);
    }

    @Test
    public void test2() {
        int[] nums = {3, 2, 1};
        nextPermutation(nums);
        PrintKit.print(nums);
    }

    @Test
    public void test3() {
        int[] nums = {1, 1, 5};
        nextPermutation(nums);
        PrintKit.print(nums);
    }

    @Test
    public void test4() {
        int[] nums = {1, 3, 2};
        nextPermutation(nums);
        PrintKit.print(nums);
    }
}
