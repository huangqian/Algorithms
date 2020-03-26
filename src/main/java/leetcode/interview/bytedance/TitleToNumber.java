package leetcode.interview.bytedance;

import org.junit.Test;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/24 - 17:02
 * @description: <pre>
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * 示例 1:
 *
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 *
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 *
 * 输入: "ZY"
 * 输出: 701
 * </pre>
 */
public class TitleToNumber {

    public int titleToNumber(String s) {
        s = s.toUpperCase();
        int val = 0;
        for (int i = 0; i < s.length(); i++) {
            val = val * 26 + (s.charAt(i) - 64);
        }
        return val;
    }

    @Test
    public void test() {
        int val = (char) 'A';
        System.out.println(val);
    }

    @Test
    public void test1() {
        System.out.println("A -> " + titleToNumber("A"));
        System.out.println("B -> " + titleToNumber("B"));
        System.out.println("C -> " + titleToNumber("C"));
        System.out.println("Z -> " + titleToNumber("Z"));
        System.out.println("AA -> " + titleToNumber("AA"));
        System.out.println("AB -> " + titleToNumber("AB"));
    }
}
