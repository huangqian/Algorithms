package leetcode.interview.bytedance.t20200505;

import leetcode.PrintKit;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/5/5 - 23:55
 * @description:
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        backtrack(res, "", 0, 0, n);
        return res;
    }

    public void backtrack(List<String> res, String cur, int left, int right, int n) {
        if (left == right && left == n) {
            res.add(cur);
            return;
        }
        if (left < n) {
            backtrack(res, cur + "(", left + 1, right, n);
        }

        if (right < left) {
            backtrack(res, cur + ")", left, right + 1, n);
        }
    }

    @Test
    public void test(){
        List<String> res = generateParenthesis(3);
        PrintKit.printOf(res);
    }
}
