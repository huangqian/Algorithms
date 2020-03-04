package leetcode;

import org.junit.Test;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/4 - 16:48
 * @description: 盛最多水的容器
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * <p>
 * <p>
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 * <p>
 * 来源：力扣（LeetCode）
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int max = 0;
        int area;
        int waterMark;
        for (int i = 1; i < height.length; i++) {
            for (int k = 0; k < i; k++) {
                waterMark = Math.min(height[k], height[i]);
                area = waterMark * (i - k);
                if (area > max) {
                    max = area;
                }
            }
        }
        return max;
    }

    public int maxAreaByDoublePointer(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int max = 0;
        while (start < end) {
            max = Math.max(max, Math.min(height[start], height[end]) * (end - start));
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }

        }
        return max;
    }

    public int maxAreaByDoublePointer2(int[] height) {

        int start = height.length / 2;
        int end = start + 1;
        int max = 0;
        while (start >= 0 && end < height.length) {
            max = Math.max(max, Math.min(height[start], height[end]) * (end - start));
            if (start == 0) {
                end++;
            } else if (end == height.length - 1) {
                start--;
            } else {
                if (height[start] < height[end]) {
                    start--;
                } else {
                    end++;
                }
            }
        }
        return max;
    }

    @Test
    public void test() {

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
        System.out.println(maxAreaByDoublePointer(height));
        System.out.println(maxAreaByDoublePointer2(height));
    }
}
