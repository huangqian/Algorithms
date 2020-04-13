package leetcode.dp;

import org.junit.Test;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/4/10 - 22:44
 * @description: 3. 无重复字符的最长子串
 * <pre>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 */
public class LongestSubstringWithoutRepeatingCharactersByDP {

    /**
     * 解题思路： 动态规划
     * 1. 状态定义 dp[n]是从0开始截止到下标为n的字符串之间的最长无重复字符串的子串长度
     * 2. 状态转移方程 dp[n] = max(dp[n-1], sub.substring(index, cur).length())
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        StringBuilder sub = new StringBuilder();
        sub.append(s.charAt(0));
        dp[0] = 1;
        int index;
        for (int i = 1; i < s.length(); i++) {
            index = indexOf(sub, s.charAt(i));
            //子串中存在了和当前字符相同的字符。
            if (index >= 0) {
                sub.delete(0, index + 1);
            }
            sub.append(s.charAt(i));
            dp[i] = Math.max(dp[i - 1], sub.length());
        }
        return dp[s.length() - 1];
    }

    public int indexOf(StringBuilder sb, char ch) {
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ch) return i;
        }
        return -1;
    }

    @Test
    public void test1() {
        String s = "au";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
