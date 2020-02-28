package leetcode;

import java.util.*;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/2/12 - 23:56
 * @description: 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreedSum {

    /**
     * 这个问题拆解成 a + b = -c的问题，就是成了两个数字之和等于指定值，通过这个方法找到元祖。
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        List<List<Integer>> tripleList = new ArrayList<>();
        List<Integer> triple;
        HashSet<List<Integer>> tripleSet = new HashSet<List<Integer>>();
        for (int i = 0; i <= nums.length - 3; i++) {
            for (int k = i + 1; k < nums.length - 1; k++) {
                if (map.containsKey(-nums[i] - nums[k])
                        && map.get(-nums[i] - nums[k]) > k
                        && map.get(-nums[i] - nums[k]) > i) {
                    triple = Arrays.asList(nums[i], nums[k], nums[map.get(-nums[i] - nums[k])]);
                    Collections.sort(triple);
                    if (!tripleSet.contains(triple)) {
                        tripleList.add(triple);
                        tripleSet.add(triple);
                    }

                }
            }
        }
        return tripleList;
    }

    public static void main(String[] args) {
        //{-1, 0, 1, 2, -1, -4};
        int[] nums = {0,0,0};
        List<List<Integer>> tripleList = threeSum(nums);
        System.out.println(tripleList);
    }
}
