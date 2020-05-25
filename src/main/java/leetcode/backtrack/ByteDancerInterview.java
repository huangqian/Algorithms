package leetcode.backtrack;

import leetcode.PrintKit;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/5/14 - 18:09
 * @description:
 */
public class ByteDancerInterview {

    /**
     * 给一个无序数组nums和整数m，返回m个元素的排列组合。需要保证是有序的
     */
    public List<List<Integer>> cnm(int[] nums, int m) {
        if (nums == null || nums.length == 0 || m <= 0) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums, m, 0);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> item, int[] nums, int size, int start) {
        if (item.size() == size) {
            res.add(new ArrayList<>(item));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            item.add(nums[i]);
            backtrack(res, item, nums, size, i + 1);
            item.remove(Integer.valueOf(nums[i]));

        }
    }

    @Test
    public void test01() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = cnm(nums, 2);
        PrintKit.print(res);
    }

    @Test
    public void test02() {
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> res = cnm(nums, 3);
        PrintKit.print(res);
    }
}

