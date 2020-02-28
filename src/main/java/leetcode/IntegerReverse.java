package leetcode;

import org.junit.Test;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/2/15 - 20:50
 * @description: 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 */
public class IntegerReverse {

    public static int reverse(int x) {
        int result = 0;
        int i;
        while (x != 0) {
            i = x % 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && i > Integer.MAX_VALUE % 10)) {//溢出
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && i < Integer.MIN_VALUE % 10)) {
                return 0;
            }

            result = result * 10 + i;
            x = x / 10;

        }

        return result;
    }

    @Test
    public void test() {

        System.out.println((-10 % 10));
        System.out.println(Integer.MAX_VALUE % 10);
        System.out.println(Integer.MIN_VALUE % 10);

    }

    @Test
    public void test1() {
        System.out.println(reverse(-123));
    }

    @Test
    public void test2() {
        System.out.println(reverse(-120));
    }

    @Test
    public void test3() {
        System.out.println(reverse(3));
    }

    @Test
    public void test4() {
        System.out.println(reverse(1202030));
    }

    @Test
    public void test5() {
        //测试溢出
        System.out.println(reverse(1534236469));
    }

    @Test
    public void test6() {
        System.out.println(reverse(-126087180));
    }

    @Test
    public void test7() {
        System.out.println(reverse(-2147483648));
    }

}
