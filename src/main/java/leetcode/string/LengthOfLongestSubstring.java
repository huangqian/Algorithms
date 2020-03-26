package leetcode.string;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/2/13 - 23:12
 * @description: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 */
public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] arr = new int[s.length()];
        arr[0] = 1;

        String sub = s.substring(0, 1);
        String ch;
        int index;
        for (int i = 1; i < s.length(); i++) {
            ch = s.substring(i, i+1);
            index = sub.indexOf(ch);
            sub += ch;
            if (index >= 0) {
                sub = sub.substring(index + 1) ;
                arr[i] = arr[i - 1];
            } else {
                arr[i] = Math.max(arr[i - 1], sub.length());
            }
        }
        return arr[s.length() - 1];
    }

    public static int getMaxLength(String s, int index, Set<String> set) {
        if (index == 1) {
            return 1;
        }
        String c = s.substring(index, index + 1);
        if (set.contains(c)) {
            return getMaxLength(s, index - 1, set);
        } else {
            set.add(c);
            return getMaxLength(s, index - 1, set) + 1;
        }
    }

    @Test
    public void test1() {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    @Test
    public void test2() {
        String s = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    @Test
    public void test3() {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

    @Test
    public void test4() {
        String s = "dvdf";
        System.out.println(lengthOfLongestSubstring(s));
    }

    @Test
    public void test5() {
        String s = "";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
