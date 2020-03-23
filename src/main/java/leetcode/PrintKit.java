package leetcode;

import java.util.Iterator;
import java.util.List;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/23 - 11:32
 * @description:
 */
public final class PrintKit {

    public static void print(List<List<Integer>> res) {
        Iterator<List<Integer>> levelIterator = res.iterator();
        System.out.println("[");
        while (levelIterator.hasNext()) {
            Iterator<Integer> vals = levelIterator.next().iterator();
            System.out.print("[");
            while (vals.hasNext()) {
                System.out.print(vals.next());
                if (vals.hasNext()) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            if (levelIterator.hasNext()) {
                System.out.print(",");
            }
            System.out.println();
        }
        System.out.println("]");
    }
}
