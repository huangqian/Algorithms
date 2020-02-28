package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/2/14 - 00:20
 * @description: 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 */
public class LongestPalindrome {

    /**
     * 解题思路：通过滑动窗口[i,r)
     */
    public static String longestPalindrome(String s) {

        if (s == null || s.length() < 2) {
            return s;
        }

        String ans = "";
        int start = 0;
        int end = 1;
        int found;
        while (end < s.length()) {
            //开始元素碰到了或者到末尾了，触发窗口滑动
            found = s.indexOf(s.charAt(end), start);
            if (found >= start && found < end
                    || end == s.length() - 1) {
                ans = ans.length() >= (end - found + 1) ? ans : s.substring(found, end + 1);
                start = end;
            }
            end++;
        }
        return ans;
    }


    /**
     * 动态规划的递推方案：
     * 构造一个字符串数组ans[]，下表为i的标识输入字符串s在其索引区间0-i之间，ans[i]为最大的回文字符串。
     * 那么它的递推方程式
     * 对于ans[n]
     *      if(s.charAt(n/2) == s.charAt(n):
     *          ans[n] = ans[n-1] + s.charAt(n)
     *      else:
     *          ans[n] = ans[n-1]
     */
    public static String longestPalindromeByDp(String s) {

        if (s == null || s.length() < 2) {
            return "";
        }

        String[] ans = new String[s.length()];

        return ans[s.length() - 1];


    }

    @Test
    public void test1() {
        String s = "babad";
        System.out.println(longestPalindrome(s));

    }

    @Test
    public void test2() {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));

    }

    @Test
    public void test3() {
        String s = "ccc";
        System.out.println(longestPalindrome(s));

    }

    @Test
    public void test4(){
        String[][] grid = new String[4][6];

        String val = grid[0][1];
        System.out.println(val);
    }
}

