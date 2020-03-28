package leetcode.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/19 - 18:22
 * @description: 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();

        List<Integer> numList = new ArrayList<>();
        for(int n : nums){
            numList.add(n);
        }

        backtrack(output, numList, nums.length, 0);
        return output;
    }

    public void backtrack(List<List<Integer>> output, List<Integer> nums, int size, int first){
        if(first == size){
            output.add(new LinkedList<>(nums));
            return;
        }
        for(int i = first; i < size; i++){

            Collections.swap(nums, first, i);
            backtrack(output, nums, size, first + 1);
            Collections.swap(nums, first, i);
        }
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> list = permute(nums);
        for(List<Integer> ints : list){
            System.out.print("[");
            for(int i : ints){
                System.out.print(i+ " ");
            }
            System.out.println("]");
        }
    }
}
