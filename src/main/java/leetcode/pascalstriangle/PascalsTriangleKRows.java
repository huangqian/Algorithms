package leetcode.pascalstriangle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/5 - 18:33
 * @description: 杨辉三角
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 示例:
 * 输入: 3
 * 输出: [1,3,3,1]
 */
public class PascalsTriangleKRows {

    public List<Integer> getRow(int rowIndex) {
        int[][] rows = new int[rowIndex + 1][rowIndex + 1];
        rows[0][0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            for (int m = 0; m <= i; m++) {
                rows[i][m] = (m % i == 0) ? 1 : rows[i - 1][m - 1] + rows[i - 1][m];
            }
        }
        List<Integer> columns = new ArrayList<>();
        for (int e : rows[rowIndex]) {
            columns.add(e);
        }
        return columns;

    }

    @Test
    public void test(){
        for(int i= 0; i < 7; i++) {
            List<Integer> row = getRow(i);
            System.out.println(row);
        }
    }
}
