package leetcode.math;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/4/3 - 21:49
 * @description:
 */
public class Maths {

    /**
     * 计算绝对值
     */
    public static int abs(int x) {
        return x < 0 ? -x : x;
    }

    /**
     * 计算平方根
     */
    public static double sqrt(double c) {
        if (c < 0) return Double.NaN;
        double err = 1e-15;
        double t = c;
        while (Math.abs(t - c / t) > err * t) {
            t = (c / t + t) / 2.0;
        }
        return t;
    }

    /**
     * 判断一个数字是否是素数
     */
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
