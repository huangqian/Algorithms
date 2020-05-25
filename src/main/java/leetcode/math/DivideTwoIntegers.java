package leetcode.math;

import org.junit.Test;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/5/14 - 21:37
 * @description: 29. 两数相除
 * <pre>
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 *  
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 *  
 *
 * 提示：
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 */
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if (Math.abs(dividend) < Math.abs(divisor)) return 0;
        boolean isMinus = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        long absDividend = Math.abs(dividend);
        long absDivisor = Math.abs(divisor);
        long absVal = 0;
        while (absDividend >= absDivisor) {
            absVal++;
            absDividend -= absDivisor;
        }
        return (int) (isMinus ? -absVal : absVal);
    }

    @Test
    public void test01() {
        System.out.println("10/3=" + divide(10, 3));
    }
}
