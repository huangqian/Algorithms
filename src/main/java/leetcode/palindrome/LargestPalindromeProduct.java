package leetcode.palindrome;

import org.junit.Test;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/15 - 15:10
 * @description: 479. 最大回文数乘积
 * 你需要找到由两个 n 位数的乘积组成的最大回文数。
 * <p>
 * 由于结果会很大，你只需返回最大回文数 mod 1337得到的结果。
 * <p>
 * 示例:
 * <p>
 * 输入: 2
 * <p>
 * 输出: 987
 * <p>
 * 解释: 99 x 91 = 9009, 9009 % 1337 = 987
 * <p>
 * 说明:
 * <p>
 * n 的取值范围为 [1,8]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-palindrome-product
 */
public class LargestPalindromeProduct {

    public int largestPalindrome(int n) {
        long maxNNum = 0;
        while (n > 0) {
            maxNNum = maxNNum * 10 + 9;
            n--;
        }
        long max = maxNNum * maxNNum;
        long result;
        long i = max;
        for(;  i > 0; i--){
            if(isPalindrome(i)){
                for(long k = maxNNum; k > 0; k--){
                    if(i % k == 0){
                        result = (int) (i/k);
                        if(result <= maxNNum && result > 0){
                            return (int) i;
                        }
                    }
                }
            }
        }
        return 0;
    }

    public boolean isPalindrome(long x) {
        String s = String.valueOf(x);
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
//        System.out.println(largestPalindrome(1));
//        System.out.println(largestPalindrome(2));
//        System.out.println(largestPalindrome(3));
//        System.out.println(largestPalindrome(4));
        System.out.println(largestPalindrome(5));
        System.out.println(largestPalindrome(6));
        System.out.println(largestPalindrome(7));
        System.out.println(largestPalindrome(8));
    }

    @Test
    public void test1() {
        System.out.println(99013 * 99993);
    }
}
