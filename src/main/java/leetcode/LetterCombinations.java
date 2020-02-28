package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/2/13 - 14:02
 * @description: 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 */
public class LetterCombinations {

    public static List<String> letterCombinations(String digits) {
        String[][] matrix = {
                {"a", "b", "c", null},
                {"d", "e", "f", null},
                {"g", "h", "i", null},
                {"j", "k", "i", null},
                {"m", "n", "o", null},
                {"p", "q", "r", "s"},
                {"t", "u", "v", null},
                {"w", "x", "y", "z"}};
        List<String> list = new ArrayList<>();



        return list;
    }



    @Test
    public void testLetterCombinations(){
        List<String> list = letterCombinations("23");
        System.out.println(list);
    }

    @Test
    public void test() {
        int v = (char) "49".charAt(0);
        System.out.println("23".charAt(0));
        System.out.println((char) 0);
    }

    @Test
    public void test2() {
        String[][] matrix = {
                {"a", "b", "c"},
                {"d", "e", "f",},
                {"g", "h", "i",},
                {"j", "k", "i",},
                {"m", "n", "o",},
                {"p", "q", "r", "s"},
                {"t", "u", "v",},
                {"w", "x", "y", "z"}};
        System.out.println(matrix.toString());
    }

}
