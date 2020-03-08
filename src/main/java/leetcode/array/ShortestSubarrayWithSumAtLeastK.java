package leetcode.array;

import org.junit.Test;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/8 - 15:27
 * @description: 862. 和至少为 K 的最短子数组
 * 返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
 * <p>
 * 如果没有和至少为 K 的非空子数组，返回 -1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1], K = 1
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：A = [1,2], K = 4
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：A = [2,-1,2], K = 3
 * 输出：3
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 50000
 * -10 ^ 5 <= A[i] <= 10 ^ 5
 * 1 <= K <= 10 ^ 9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-subarray-with-sum-at-least-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ShortestSubarrayWithSumAtLeastK {


    /**
     * 思路：
     * 滑动窗口，sum为窗口内累计的数值，当sum >= K，开始从左侧缩小窗口，计算当前窗口大小和最小窗口的之间最小值，当sum < K时，窗口的右边开始向前滑动一位。
     */
    public int shortestSubarray(int[] A, int K) {
        int minLength = -1;
        int sum = 0;
        int start = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum <= 0) {//如果前面累计的小于等于0，说明对于累计大于K没有实际贡献，必然不是最小的长度
                start = i + 1;
                sum = 0;
                continue;
            }
            if (sum >= K) {
                minLength = minLength == -1 ? i - start + 1 : Math.min(minLength, i - start + 1);
                start = i - 1;
                sum = A[i];
                while (start >= 0 && sum < K) {
                    sum += A[start];
                    start--;
                }
                minLength = Math.min(minLength, i - start);
            }

        }
        return minLength;
    }

    @Test
    public void test1() {
        int[] A = {1};
        System.out.println(shortestSubarray(A, 1));
    }

    @Test
    public void test2() {
        int[] A = {1, 2};
        System.out.println(shortestSubarray(A, 4));
    }


    @Test
    public void test3() {
        int[] A = {2, 1, 2};
        System.out.println(shortestSubarray(A, 3));
    }

    @Test
    public void test4() {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(shortestSubarray(A, 9));
    }

    @Test
    public void test5() {
        int[] A = {84, -37, 32, 40, 95};
        System.out.println(shortestSubarray(A, 167));
    }

    @Test
    public void test6() {
        int[] A = {-34, 37, 51, 3, -12, -50, 51, 100, -47, 99, 34, 14, -13, 89, 31, -14, -44, 23, -38, 6};
        System.out.println(shortestSubarray(A, 151));
    }

}
