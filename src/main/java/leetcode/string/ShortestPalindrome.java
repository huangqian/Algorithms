package leetcode.string;

import org.junit.Test;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/2/29 - 18:28
 * @description: leetcode-214: 最短回文字符串
 * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "aacecaaa"
 * 输出: "aaacecaaa"
 * 示例 2:
 * <p>
 * 输入: "abcd"
 * 输出: "dcbabcd"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-palindrome
 */
public class ShortestPalindrome {

    /**
     * 其本质是原字符串中左边字符串全部的最大回文字符串，然后得到的回文字符串后的剩余进行补充
     *
     * @param s
     * @return
     */
    public String shortestPalindrome(String s) {
        return null;
    }


    @Test
    public void test() {

        String s = "aacecaaa";
        System.out.println(shortestPalindrome(s));

    }

    @Test
    public void test1() {
        String s = "a";
        System.out.println(shortestPalindrome(s));
    }

    @Test
    public void test2() {
        String s = "abcd";
        System.out.println(shortestPalindrome(s));
    }

}
