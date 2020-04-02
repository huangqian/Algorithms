package leetcode.interview.bytedance.t20200402;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/4/2 - 14:17
 * @description: 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <pre>
 * 示例 1:
 *
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 *
 * 输入: "leetcode"
 * 输出: "leotcede"
 * </pre>
 */
public class ReverseVowels {

    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char t;
        StringBuilder sb = new StringBuilder(s);
        int right = sb.length() - 1;
        int left = 0;
        while (left < right) {
            while (left < right && !vowels.contains(sb.charAt(left))) left++;
            while (left < right && !vowels.contains(sb.charAt(right))) right--;
            if (left < right) {
                t = sb.charAt(right);
                sb.setCharAt(right, sb.charAt(left));
                sb.setCharAt(left, t);
            }
            left++;
            right--;
        }
        return sb.toString();
    }

    @Test
    public void test1() {
        String s = "hello";
        System.out.println(reverseVowels(s));
    }
}
