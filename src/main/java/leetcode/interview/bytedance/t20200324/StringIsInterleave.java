package leetcode.interview.bytedance.t20200324;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/24 - 17:48
 * @description: 交错字符串
 * <pre>
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 *
 * 示例 1:
 *
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 * 示例 2:
 *
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出: false
 * </pre>
 */
public class StringIsInterleave {

    /**
     * 核心难点是：
     * 1. 谁先开始
     * 2. step是多少
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (isEmpty(s1) || isEmpty(s2) || isEmpty(s3)) return false;
        //第一个不同的字符串位置
        int k = 0;
        int len = Math.min(s1.length(), s2.length());
        while (k < len && s1.charAt(k) == s2.charAt(k)) k++;

        return false;

    }

    public boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }
}
