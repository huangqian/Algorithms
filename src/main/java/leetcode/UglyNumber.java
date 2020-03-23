package leetcode;

import org.junit.Test;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/15 - 15:02
 * @description: 263. 丑数
 * 编写一个程序判断给定的数是否为丑数。
 * <p>
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 6
 * 输出: true
 * 解释: 6 = 2 × 3
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: true
 * 解释: 8 = 2 × 2 × 2
 * 示例 3:
 * <p>
 * 输入: 14
 * 输出: false
 * 解释: 14 不是丑数，因为它包含了另外一个质因数 7。
 * 说明：
 * <p>
 * 1 是丑数。
 * 输入不会超过 32 位有符号整数的范围: [−231,  231 − 1]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ugly-number
 */
public class UglyNumber {

    public boolean isUgly(int num) {
        if (num == 1) return true;
        while (num >= 2) {
            num = num % 2 == 0 ? num / 2 : num % 3 == 0 ? num / 3 : num % 5 == 0 ? num / 5 : 0;
//            if (num % 2 == 0) {
//                num = num / 2;
//            } else if (num % 3 == 0) {
//                num = num / 3;
//            } else if (num % 5 == 0) {
//                num = num / 5;
//            } else {
//                return false;
//            }
        }
        return num == 1;
    }

    @Test
    public void test1() {
        System.out.println(isUgly(8));
        System.out.println(isUgly(10));
        System.out.println(isUgly(14));
    }
}
