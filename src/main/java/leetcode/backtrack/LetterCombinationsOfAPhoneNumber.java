package leetcode.backtrack;

import leetcode.PrintKit;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/4/3 - 17:26
 * @description: 17. 电话号码的字母组合
 * <pre>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * </pre>
 */
public class LetterCombinationsOfAPhoneNumber {


    /**
     * 题解思路：回溯
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;

        Map<Character, String> dict = new HashMap<>();
        dict.put('2', "abc");
        dict.put('3', "def");
        dict.put('4', "ghi");
        dict.put('5', "jkl");
        dict.put('6', "mno");
        dict.put('7', "pqrs");
        dict.put('8', "tuv");
        dict.put('9', "wxyz");

        backtrack(res, digits, 0, "", dict);
        return res;
    }

    public void backtrack(List<String> res, String digits, int digitsIndex, String combination, Map<Character, String> dict) {
        //已经完成了
        if (digitsIndex == digits.length()) {
            res.add(combination);
            return;
        }
        char c = digits.charAt(digitsIndex);
        String letters = dict.get(c);
        for (int i = 0; i < letters.length(); i++) {
            backtrack(res, digits, digitsIndex + 1, combination + letters.charAt(i), dict);
        }
    }

    @Test
    public void test() {
        List<String> res = letterCombinations("23");
        PrintKit.printOf(res);
    }
}
