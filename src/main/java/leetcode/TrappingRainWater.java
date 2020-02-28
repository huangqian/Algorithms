package leetcode;

import org.junit.Test;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/2/25 - 10:31
 * @description: 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 */
public class TrappingRainWater {

    public static int trap(int[] height) {

        int capacity = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int maxLeft = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > maxLeft) {
                    maxLeft = height[j];
                }
            }

            int maxRight = 0;
            for (int k = i + 1; k < height.length; k++) {
                if (height[k] > maxRight) {
                    maxRight = height[k];
                }
            }
            int waterMark = Math.min(maxLeft, maxRight);
            if (waterMark > height[i]) {
                capacity = capacity + waterMark - height[i];
            }
        }

        return capacity;
    }


    @Test
    public void test() {

        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        int capacity = trap(height);
        System.out.println(capacity);
    }

    @Test
    public void test2() {

        int[] height = {2, 0, 2};

        int capacity = trap(height);
        System.out.println(capacity);
    }

}
