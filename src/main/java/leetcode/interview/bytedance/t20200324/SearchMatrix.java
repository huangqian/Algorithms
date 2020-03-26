package leetcode.interview.bytedance.t20200324;

import org.junit.Test;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/24 - 17:12
 * @description: <pre>
 *     编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 * </pre>
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0
                || target < matrix[0][0]
                || target > matrix[matrix.length - 1][matrix[0].length - 1]) return false;
        int row = 0;
        while (row < matrix.length && matrix[row][matrix[row].length - 1] < target) row++;

        int l = 0, j = matrix[row].length - 1;
        int middle;
        while (l <= j) {
            middle = (l + j) / 2;
            if (matrix[row][middle] > target) {
                j = middle - 1;
            } else if (matrix[row][middle] < target) {
                l = middle + 1;
            } else {
                return true;
            }
        }

        return false;
    }

    @Test
    public void test() {

        int[][] matrix = new int[5][4];
        System.out.println(matrix.length);
    }

    @Test
    public void test1() {

        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(searchMatrix(matrix, 3));
    }

    @Test
    public void test2() {

        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(searchMatrix(matrix, 13));
    }

    @Test
    public void test3() {

        int[][] matrix = {
                {1}
        };
        System.out.println(searchMatrix(matrix, 1));
    }

    @Test
    public void test4() {

        int[][] matrix = {
                {1},
                {3}
        };
        System.out.println(searchMatrix(matrix, 3));
    }

    @Test
    public void test5() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(searchMatrix(matrix, 3));
    }
}
