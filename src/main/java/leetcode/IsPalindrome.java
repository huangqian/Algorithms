package leetcode;

import org.junit.Test;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/2/15 - 23:29
 * @description: 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * <p>
 * 你能不将整数转为字符串来解决这个问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 */
public class IsPalindrome {

    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }


    @Test
    public void test1() {
        System.out.println(isPalindrome(1));
        System.out.println(isPalindrome(11));
        System.out.println(isPalindrome(111));
        System.out.println(isPalindrome(1111));
        System.out.println(isPalindrome(2112));
        System.out.println(isPalindrome(2135312));
    }

    @Test
    public void test2() {
//        System.out.println(isPalindromeByNumber(1));
//        System.out.println(isPalindromeByNumber(11));
//        System.out.println(isPalindromeByNumber(111));
//        System.out.println(isPalindromeByNumber(1111));
//        System.out.println(isPalindromeByNumber(2112));
//        System.out.println(isPalindromeByNumber(2135312));
    }
}
