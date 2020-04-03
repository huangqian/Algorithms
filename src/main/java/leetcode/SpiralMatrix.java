package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/4/3 - 00:23
 * @description: 54. 螺旋矩阵
 * <pre>
 *   给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        int firstRow = 0;
        int firstColumn = 0;
        int lastRow = matrix.length - 1;
        int lastColumn = matrix[0].length - 1;
        while (firstRow <= lastRow && firstColumn <= lastColumn) {
            // 从左到右
            for (int l = firstColumn; l <= lastColumn; l++) {
                res.add(matrix[firstRow][l]);
            }
            firstRow++;
            if (firstRow <= lastRow && firstColumn <= lastColumn) {
                // 从上到下
                for (int h = firstRow; h <= lastRow; h++) {
                    res.add(matrix[h][lastColumn]);
                }
            }
            lastColumn--;
            if (firstRow <= lastRow && firstColumn <= lastColumn) {
                // 从右到左
                for (int r = lastColumn; r >= firstColumn; r--) {
                    res.add(matrix[lastRow][r]);
                }
                lastRow--;
            }
            if (firstRow <= lastRow && firstColumn <= lastColumn) {
                // 从下到上
                for (int r = lastRow; r >= firstRow; r--) {
                    res.add(matrix[r][firstColumn]);
                }
                firstColumn++;
            }
        }
        return res;
    }
}
