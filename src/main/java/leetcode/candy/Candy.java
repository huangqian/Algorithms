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

    /**
     * 思路：
     * 构造一个数组candy[i]表示第i+1个应该得到的糖果数
     * 1. 先满足每个人1个颗糖果
     * 2. 从左到右，挨个和左边相邻的比较，当前节点是否需要增加。
     * 3. 从右向左挨个和右边相邻的比较，当前节点是否需要增加。
     * 4. 对
     */
    public int candy(int[] ratings) {

        if (ratings == null || ratings.length == 0) return 0;
        //candy[i]数组表示第i+1个个学生应该得到的糖果
        int[] candys = new int[ratings.length];
        //满足至少一颗
        for (int i = 0; i < ratings.length; i++) {
            candys[i] = 1;
        }
        //从左到右，挨个和左边相邻的比较，当前节点是否需要增加。
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candys[i] = candys[i - 1] + 1;
            }
        }
        //从右边往左看，挨个和左边相邻的比较，当前节点是否需要增加。
        for (int k = ratings.length - 2; k >= 0; k--) {
            if (ratings[k] > ratings[k + 1] && candys[k] <= candys[k + 1]) {
                candys[k] = candys[k + 1] + 1;
            }
        }
        int count = 0;
        for (int candy : candys) {
            count += candy;
        }
        return count;
    }


    @Test
    public void test1() {
        int[] ratings = {1, 0, 2};
        System.out.println(candy(ratings));
    }

    @Test
    public void test2() {
        int[] ratings = {1, 2, 2};
        System.out.println(candy(ratings));
    }
}
