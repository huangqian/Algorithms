package leetcode.interview.bytedance;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/5/12 - 16:35
 * @description: <pre>
 *
 * 消除游戏， leetcode 390
 * 给定一个从1 到 n 排序的整数列表。
 * 首先，从左到右，从第一个数字开始，每隔一个数字进行删除，直到列表的末尾。
 * 第二步，在剩下的数字中，从右到左，从倒数第一个数字开始，每隔一个数字进行删除，直到列表开头。
 * 我们不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
 * 返回长度为 n 的列表中，最后剩下的数字。
 *
 * 示例：
 *
 *      输入:
 *      n = 9,
 *      1 2 3 4 5 6 7 8 9
 *      2 4 6 8
 *      2 6
 *      6
 *
 *      输出:
 *      6
 * </pre>
 */
public class LastRemaining {


    public int lastRemaining(int n) {
        return n == 1 ? 1 : 2 * (n / 2 + 1 - lastRemaining(n / 2));
    }

    @Test
    public void test() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.remove(0);
        System.out.println(list.get(0));
    }

    @Test
    public void test1() {
        int v = lastRemaining(9);
        System.out.println(v);
    }

}
