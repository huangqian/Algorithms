package leetcode.backtrack;

import leetcode.PrintKit;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/4/3 - 17:00
 * @description: 22. 括号生成
 * <pre>
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * </pre>
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) return res;
        genByBacktrack("", res, 0, 0, n);
        return res;
    }

    /**
     * 回溯的方式生成有效的组合
     *
     * @param s     有效的组合
     * @param res   返回结果容器
     * @param left  已经使用的左括号数量
     * @param right 已经使用的右括号数量
     * @param n     括号对数
     */
    public void genByBacktrack(String s, List<String> res, int left, int right, int n) {
        //左括号和右括号都使用完毕了，标识已经组合完毕，直接加入到返回结果
        if (left == n && right == n) {
            res.add(s);
            return;
        }
        //如果左括号有还有剩余，可以继续放
        if (left < n) {
            genByBacktrack(s + "(", res, left + 1, right, n);
        }

        //如果右边括号数量小于左边括号，才能添加右边括号，否则生成无效的组合。
        if (right < left) {
            genByBacktrack(s + ")", res, left, right + 1, n);
        }
    }

    @Test
    public void test(){
        List<String> res = generateParenthesis(3);
        PrintKit.printOf(res);
    }
}
