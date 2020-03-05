package leetcode.pascalstriangle;

import org.junit.Test;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/5 - 14:14
 * @description: 杨辉三角打印成金字塔
 */
public class PascalsTrianglePrint {

    public void yangHuiTrianglePrint(int n) {
        int[][] table = new int[n][2 * n + 1];
        table[0][n] = 1;
        for (int k = 1; k < n; k++) {
            for (int j = n - k; j <= n + k; j++) {
                table[k][j] = table[k - 1][j - 1] + table[k - 1][j + 1];
            }
        }


        for (int[] row : table) {
            for (int cell : row) {
                if (cell == 0) {
                    System.out.print(" ");
                } else {
                    System.out.printf("%d", cell);
                }
            }
            System.out.println();

        }

    }

    public int[][] createYangHuiTriangle(int n) {
        int[][] data = new int[n][n + 1];
        data[0][1] = 1;
        for (int k = 1; k < n; k++) {
            for (int j = 1; j < n; j++) {
                data[k][j] = data[k - 1][j - 1] + data[k - 1][j];
            }
        }
        return data;
    }

    @Test
    public void test() {
        yangHuiTrianglePrint(5);

    }
}
