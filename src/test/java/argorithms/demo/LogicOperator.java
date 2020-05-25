package argorithms.demo;

import org.junit.Test;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/5/19 - 23:16
 * @description:
 */
public class LogicOperator {

    /**
     * int 整数的按位做&运算
     */
    @Test
    public void intBitAndOperator() {
        System.out.println("1&3=" + (int) (1 & 3));
        System.out.println("3&7=" + (int) (3 & 7));
        System.out.println("3&3=" + (int) (3 & 3));
        System.out.println("19&7=" + (int) (21 & 7));
        System.out.println("8&7=" + (int) (8 & 7));

    }

    @Test
    public void intRightForward() {
        System.out.println((int) (8 >>> 4));
        System.out.println((int) (8 >>> 3));
        System.out.println((int) (8 >>> 2));
        System.out.println((int) (8 >>> 1));
    }

    @Test
    public void integerBitCount() {
        System.out.println(Integer.bitCount(3));
        System.out.println(Integer.bitCount(8));
        System.out.println(Integer.bitCount(15));
        System.out.println(Integer.bitCount(16));
        System.out.println(Integer.bitCount(17));
    }
}
