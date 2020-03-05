package leetcode.pascalstriangle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/5 - 17:54
 * @description: 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * <p>
 * <p>
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 */
public class PascalsTriangleGenerator {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<>();
        List<Integer> columns;
        int val;
        for (int i = 0; i < numRows; i++) {
            columns = new ArrayList<>(i);
            for (int k = 0; k < i + 1; k++) {
                val = (k == 0 || k == i) ? 1 : rows.get(i - 1).get(k - 1) + rows.get(i - 1).get(k);
                columns.add(val);
            }
            rows.add(columns);
        }

        return rows;
    }

    @Test
    public void test() {
        List<List<Integer>> rows = generate(5);
        System.out.println(rows);
    }
}
