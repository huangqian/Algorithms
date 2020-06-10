package leetcode.string;

import org.junit.Test;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/6/4 - 11:23
 * @description: 实现 strStr()
 * <pre>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 */
public class ImplementStrStr {

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        if (needle.length() == 0) return 0;
        int j;
        int size;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                size = Math.min(haystack.length() - i, needle.length());
                for (j = 1; j < size && haystack.charAt(i + j) == needle.charAt(j); j++) ;
                if (j == needle.length()) return i;
            }
        }

        return -1;
    }


    @Test
    public void test01() {
        System.out.println(strStr("mississippi", "issip"));
    }

    @Test
    public void test02() {
        System.out.println(strStr("", ""));
    }
}



