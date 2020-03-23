package leetcode.string;

import org.junit.Test;

import java.util.Stack;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/12 - 15:52
 * @description: 32. 最长有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        if (s.length() < 2) return 0;
        //定义一个数组：存储从索引0到n之间的最大的字符串的长度maxLengths[n]
        int[] maxLengths = new int[s.length()];

        //字符串匹配的栈
        Stack<Character> stack = new Stack<>();
        //被压入栈中的字符串对应的索引的栈
        Stack<Integer> indexStack = new Stack<>();
        stack.push(s.charAt(0));
        indexStack.push(0);
        maxLengths[0] = 0;
        int retainsIndex;
        for (int i = 1; i < s.length(); i++) {
            //如果可以和栈顶匹配
            if (!stack.isEmpty() && stack.peek() == '(' && ')' == s.charAt(i)) {
                stack.pop();
                indexStack.pop();
                retainsIndex = indexStack.isEmpty() ? -1 : indexStack.peek();
                maxLengths[i] = Math.max(i - retainsIndex , maxLengths[i - 1]);
            } else {
                stack.push(s.charAt(i));
                indexStack.push(i);
                maxLengths[i] = maxLengths[i - 1];
            }
        }

        return maxLengths[s.length() - 1];
    }

    @Test
    public void test1() {
        String s = ")()())";
        System.out.println(longestValidParentheses(s));
    }

    @Test
    public void test2() {
        String s = "(()";
        System.out.println(longestValidParentheses(s));
    }

    @Test
    public void test3() {
        String s = ")(())(()()(())";
        System.out.println(longestValidParentheses(s));
    }

}
