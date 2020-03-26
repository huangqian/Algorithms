package leetcode.findnelement;

import java.util.HashMap;
import java.util.stream.Stream;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/2/12 - 22:18
 * @description: 题目来自leetcode
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindTwoElement {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int k = 0; k < nums.length -1; k++) {
            if (map.containsKey(target - nums[k]) && map.get(target - nums[k]) != k ) {
                return new int[]{k, map.get(target - nums[k])};
            }
        }
        return null;
    }


    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int[] findIndexes = twoSum(nums, 6);
        System.out.println(findIndexes[0] + "," + findIndexes[1]);
    }

}
