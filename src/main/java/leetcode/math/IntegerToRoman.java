package leetcode.math;

import org.junit.Test;

import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeMap;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/5/29 - 14:31
 * @description: 整数转罗马数字
 * <pre>
 *   罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: "III"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "IV"
 * 示例 3:
 *
 * 输入: 9
 * 输出: "IX"
 * 示例 4:
 *
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 *
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * </pre>
 */
public class IntegerToRoman {

    /**
     * 题解思路： 贪心算法，每次先除以最可除的最大数
     *
     * @param num 被转化的整数，范围 1-3999之间
     * @return 返回罗马数字字符串
     */
    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        TreeMap<Integer, String> romanTable = new TreeMap<>();
        romanTable.put(1, "I");
        romanTable.put(4, "IV");
        romanTable.put(5, "V");
        romanTable.put(9, "IX");
        romanTable.put(10, "X");
        romanTable.put(40, "XL");
        romanTable.put(50, "L");
        romanTable.put(90, "XC");
        romanTable.put(100, "C");
        romanTable.put(400, "CD");
        romanTable.put(500, "D");
        romanTable.put(900, "CM");
        romanTable.put(1000, "M");
        int retain = num;
        Map.Entry<Integer, String> entry;
        while (retain != 0) {
            entry = romanTable.floorEntry(retain);
            retain -= entry.getKey();
            ans.append(entry.getValue());
        }

        return ans.toString();
    }

    @Test
    public void testTreeMap() {
        TreeMap<Integer, String> tables = new TreeMap<>();
        tables.put(1, "I");
        tables.put(4, "IV");
        tables.put(5, "V");
        tables.put(9, "IX");
        tables.put(10, "X");
        tables.put(40, "XL");
        tables.put(50, "L");
        tables.put(90, "XC");
        tables.put(100, "C");
        tables.put(400, "CD");
        tables.put(500, "D");
        tables.put(900, "CM");
        tables.put(1000, "M");
        NavigableSet<Integer> set = tables.descendingKeySet();
        for (int key : set) {
            System.out.println("key=" + key + ", value=" + tables.get(key));
        }

        System.out.println(tables.floorKey(100));
        System.out.println(tables.floorKey(101));
        System.out.println(tables.floorKey(399));

    }

    @Test
    public void test01() {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(5));
        System.out.println(intToRoman(6));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(13));
        System.out.println(intToRoman(18));
        System.out.println(intToRoman(21));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
    }
}
