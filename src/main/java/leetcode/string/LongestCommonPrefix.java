package leetcode.string;

import org.junit.Test;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/4/5 - 23:47
 * @description: 14. 最长公共前缀
 * <pre>
 *   编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * </pre>
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int prefixIndex = -1;
        char curChar;
        boolean loop = true;
        while (loop) {
            ++prefixIndex;
            if (prefixIndex >= strs[0].length()) break;
            curChar = strs[0].charAt(prefixIndex);
            for (int i = 1; i < strs.length; i++) {
                if (prefixIndex >= strs[i].length() || strs[i].charAt(prefixIndex) != curChar) {
                    loop = false;
                    break;
                }
            }
        }
        return strs[0].substring(0, prefixIndex);
    }

    @Test
    public void test1() {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    @Test
    public void test2() {
        String[] strs = {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(strs));
    }
}
