package leetcode.string;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/2/14 - 15:51
 * @description: 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StringConvertZ {


    public static String convert(String s, int numRows) {
        if (numRows <= 1 || s.length() <= 2) {
            return s;
        }
        int numColunms = s.length() / 2 + s.length() % (2 * numRows - 2) % numRows + s.length() % (2 * numRows - 2) / numRows;
        char[][] grid = new char[numRows][numColunms];
        int row = 0;
        int column = 0;
        for (int i = 0; i < s.length(); i++) {
            grid[row][column] = s.charAt(i);
            //如果碰到最后一行，或者其正上方没有数据,下一步是向右上角移动
            if (row == 0 || (grid[row - 1][column] != 0 && (row != numRows - 1))) {
                row++;
            } else {
                row--;
                column++;
            }
        }

        gridPrint(grid);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                sb.append(grid[i][j] == 0 ? "" : grid[i][j]);
            }
        }
        return sb.toString();
    }

    public static void gridPrint(char[][] grid) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                sb.append(grid[i][j] == 0 ? " " : grid[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    @Test
    public void test() {
        char[][] grid = new char[4][6];

        char val = grid[0][1];

        System.out.println(val == 0);
        String s = new String(grid[0]);
        System.out.println(s);

        AtomicInteger atomicInt = new AtomicInteger(0);
        atomicInt.incrementAndGet();
    }

    @Test
    public void test1() {
        String str = "LEETCODEISHIRING";
        String out = convert(str, 3);
        System.out.println(out);
    }

    @Test
    public void test2() {
        String str = "LEETCODEISHIRING";
        String out = convert(str, 4);
        System.out.println(out);
    }

    @Test
    public void test3() {
        String str = "LEETCODEISHIRING";
        String out = convert(str, 1);
        System.out.println(out);
    }

    @Test
    public void test4() {
        String str = "LEETCODEISHIRING";
        String out = convert(str, 2);
        System.out.println(out);
    }

    @Test
    public void test5() {
        String str = "A";
        String out = convert(str, 2);
        System.out.println(out);
    }

    @Test
    public void test6() {
        String str = "ABC";
        String out = convert(str, 2);
        System.out.println(out);
    }
}
