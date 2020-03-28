package leetcode;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/27 - 23:48
 * @description:
 */
public class Maths {

    public static int min(int... vals) {
        int min = vals[0];
        int i = 1;
        while (i < vals.length) {
            if (vals[i] < min) min = vals[i];
        }
        return min;
    }
}
