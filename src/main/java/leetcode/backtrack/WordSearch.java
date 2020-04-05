package leetcode.backtrack;

import org.junit.Test;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/4/4 - 21:33
 * @description: 79. 单词搜索
 * <pre>
 *   给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *  
 *
 * 提示：
 *
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * </pre>
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0
                || board.length == 0 || board[0].length == 0) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (backtrack(board, word, 0, row, col, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, String word, int sIndex, int row, int column, boolean[][] visited) {
        if (sIndex >= word.length()) return true;
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length) {
            return false;
        }
        //如果当前位置已经被访问过或者不匹配，则分别向右和向下重新搜索
        if (visited[row][column] || board[row][column] != word.charAt(sIndex)) {
            return false;
        }
        visited[row][column] = true;
        //上、下、左、右、任意一个方向搜索到计算成功
        boolean result = backtrack(board, word, sIndex + 1, row, column - 1, visited)
                || backtrack(board, word, sIndex + 1, row, column + 1, visited)
                || backtrack(board, word, sIndex + 1, row - 1, column, visited)
                || backtrack(board, word, sIndex + 1, row + 1, column, visited);
        //回溯
        visited[row][column] = false;
        return result;

    }

    @Test
    public void test1() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println("word ='ABCCED' result=" + exist(board, "ABCCED"));
        System.out.println("word ='SEE' result=" + exist(board, "SEE"));
        System.out.println("word ='ABCB' result=" + exist(board, "ABCB"));
    }

    @Test
    public void test2() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println("word ='ABCESEEEFS' result=" + exist(board, "ABCESEEEFS"));
    }

    @Test
    public void test() {
        boolean[][] visited = new boolean[2][2];
        System.out.println(visited[0][1]);
    }
}
