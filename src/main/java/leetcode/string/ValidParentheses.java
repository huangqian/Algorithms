package leetcode.string;

import org.junit.Test;
import sun.tools.jstat.Jstat;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/9 - 00:36
 * @description: 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 */
public class ValidParentheses {

    public boolean isValid(String s){
        if(s.length() % 2 != 0) return false;
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(!stack.isEmpty() && map.containsKey(stack.peek()) && map.get(stack.peek()) == s.charAt(i)){
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty();
    }

    @Test
    public void test(){
        String s = "()";
        System.out.println(isValid(s));
    }

    @Test
    public void test1(){
        String s = "()[]{}";
        System.out.println(isValid(s));
    }
    @Test
    public void test2(){
        String s = "(]";
        System.out.println(isValid(s));
    }
    @Test
    public void test3(){
        String s = "([)]";
        System.out.println(isValid(s));
    }
    @Test
    public void test4(){
        String s = "{[]}";
        System.out.println(isValid(s));
    }

}
