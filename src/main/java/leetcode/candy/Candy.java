package leetcode.candy;

import org.junit.Test;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/14 - 23:38
 * @description: 135. 分发糖果
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * <p>
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2:
 * <p>
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/candy
 */
public class Candy {

    public int candy(int[] ratings) {
        int minCount = 0;
        int currMinCandyNumber = 1;
        int pre = 0;
        for (int i = 1; i < ratings.length; ) {
            if (ratings[i - 1] == ratings[i]) {
                while (ratings[i - 1] == ratings[i]) {
                    i++;
                }
                minCount += candy(ratings, pre, i - 1, currMinCandyNumber);
                pre = i;
            } else if (ratings[i - 1] > ratings[i]) {
                while (ratings[i - 1] > ratings[i]) {
                    i++;
                }
                currMinCandyNumber = 1;
                minCount += candy(ratings, pre, i - 1, currMinCandyNumber);
                pre = i;
            } else {
                while ( i < ratings.length && ratings[i - 1] < ratings[i]) {
                    i++;
                }
                if (pre != 0 && ratings[pre - 1] < ratings[pre]) {
                    minCount += candy(ratings, pre, i - 1, currMinCandyNumber + 1);
                } else {
                    minCount += candy(ratings, pre, i - 1, currMinCandyNumber);
                }
                pre = i;
            }

        }
        return minCount;
    }

    public int candy(int[] ratings, int start, int end, int min) {
        if (end < start) return 0;
        int count = min;
        int currMinCandies = min;
        if (ratings[start] == ratings[end]) {
            count += (min) * (end - start);
        } else if (ratings[start] < ratings[end]) {
            for (int i = start + 1; i <= end; i++) {
                if (ratings[i] > ratings[i - 1]) currMinCandies++;
                count += currMinCandies;
            }
        } else {
            for (int k = end - 1; k >= start; k--) {
                if (ratings[k] > ratings[k + 1]) currMinCandies++;
                count += currMinCandies;
            }
        }
        return count;
    }

    @Test
    public void test1() {
        int[] ratings = {1, 0, 2};
        System.out.println(candy(ratings));
    }

    @Test
    public void test2(){
        int[] ratings = {1,2,2};
        System.out.println(candy(ratings));
    }
}
