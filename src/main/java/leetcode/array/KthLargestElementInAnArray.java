package leetcode.array;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/8 - 23:56
 * @description: 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++){
            if(i < k){
                queue.add(nums[i]);
            }else {
                if (queue.peek() < nums[i]) {
                    queue.add(nums[i]);
                    queue.poll();
                }
            }
        }
        return queue.peek();
    }

    @Test
    public void test(){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(4);
        queue.add(5);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.peek());
    }

    @Test
    public void test1(){
        int[] nums = {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums, 2));
    }

    @Test
    public void test2(){
        int[] nums = {-1,2,0};
        System.out.println(findKthLargest(nums, 2));
    }
}
