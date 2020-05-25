package leetcode.palindrome;

import org.junit.Test;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/4/13 - 22:11
 * @description: 5. 最长回文子串
 * <pre>
 *  给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 */
public class LongestPalindromicSubstring {

    String res = "";
    int maxLength = 0;

    /**
     * 题解方案一中心扩展法。以每个字符串或者每相邻的两个作为中心进行扩展。
     * 中心扩展法是回文字符串最佳解法。
     * 此外，还可以通过滑动窗口、动态规划解答。
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        for (int i = 0; i < s.length(); i++) {
            //以每个字符作为中心扩展
            palindromeSubstringByCenterExpend(s, i, i);
            //考虑中心不是一个字符而是两个字符的情况
            palindromeSubstringByCenterExpend(s, i, i + 1);
        }
        return res;
    }

    /**
     * @param s     源字符串
     * @param left  回文字符串左边的开始位置
     * @param right 回文字符串右边的开始位置
     */
    public void palindromeSubstringByCenterExpend(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                res = s.substring(left, right + 1);
            }
            left--;
            right++;
        }
    }

    /**
     * 题解思路：动态规划。
     * <pre>
     * 1. 定义状态： dp[i][j]是从i到j的下标的子串是否是回文字符串。
     * 2. 状态转移方程 dp[i][j]  = s.charAt(i) == s.charAt(j) && (j-1 >= i+1 || dp[i+1][j-1])
     *     if s.charAt(i) != s.charAt(j) :
     *         dp[i][j] = false
     *     else
     *       dp[i][j] = j-i <= 2 || dp[i+1][j-1]
     *   为什么j-i>=2 ？ 因为要满足i+1 >= j-1。
     *   为什么是j-1 <= 2 || dp[i+1][j-1]。这是因为i=j是一定是回文字符串，如果相邻的两个元素相同也是回文字符串。
     * </pre>
     */
    public String longestPalindromeByDynamicProgram(String s) {
        if (s == null || s.length() == 0) return "";
        String ans = "";
        int max = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && max < j - i + 1) {
                    max = j - i + 1;
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }

    @Test
    public void test1() {
        String s = "babad";
        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindromeByDynamicProgram(s));
    }

    @Test
    public void test2() {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindromeByDynamicProgram(s));
    }
}
