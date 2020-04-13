package leetcode.string;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/4/10 - 15:24
 * @description: 43. 字符串相乘
 * <pre>
 *  给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * </pre>
 */
public class MultiplyStrings {


    //思路：
    // 使用队列，每次计算完毕一趟后，移除队列最后一位，拼接到字符串前面。
    // 最后对队列中的挨个从后面拼接到字符串前面
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.trim().equals("0") || num2.trim().equals("0")) return "0";

        int forward = 0;
        int sum;

        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> queue = new LinkedList<>();
        int cur;
        for (int p1 = 1; p1 <= num1.length(); p1++) {
            cur = num1.charAt(num1.length() - p1) - '0';
            //当前位为0， 0乘以任何数都是等于0，直接跳过，
            if (cur == 0) {
                if (!queue.isEmpty()) {
                    sb.insert(0, queue.removeLast());
                } else {
                    sb.insert(0, 0);
                }
                continue;
            }
            for (int p2 = 1; p2 <= num2.length(); p2++) {
                if (queue.size() >= p2) {
                    forward += queue.get(queue.size() - p2);
                }
                sum = forward + cur * (num2.charAt(num2.length() - p2) - '0');
                if (queue.size() >= p2) {
                    queue.set(queue.size() - p2, sum % 10);
                } else {
                    queue.addFirst(sum % 10);
                }
                forward = sum / 10;
            }
            if (forward > 0) {
                queue.addFirst(forward);
                forward = 0;
            }
            sb.insert(0, queue.removeLast());
        }
        while (!queue.isEmpty()) {
            sb.insert(0, queue.removeLast());
        }

        return sb.toString();
    }

    @Test
    public void test() {
        String s = "246";
        int m = s.charAt(1) - '0';
        System.out.println(m);
    }

    @Test
    public void tes1() {
        String num1 = "2";
        String num2 = "3";
        System.out.println(multiply(num1, num2));
    }

    @Test
    public void tes2() {
        String num1 = "123";
        String num2 = "456";
        System.out.println(multiply(num1, num2));
    }

    @Test
    public void tes3() {
        String num1 = "9133";
        String num2 = "0";
        System.out.println(multiply(num1, num2));
    }

    @Test
    public void tes4() {
        String num1 = "140";
        String num2 = "721";
        System.out.println(multiply(num1, num2));
    }

    @Test
    public void tes5() {
        String num1 = "408";
        String num2 = "5";
        System.out.println(multiply(num1, num2));
    }
}
