package leetcode.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/18 - 16:32
 * @description: 56. 合并区间
 * <p>
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class MergeIntervals {


    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) return intervals;
        Arrays.sort(intervals, Comparator.comparing(x -> x[0]));

        LinkedList<int[]> mergedList = new LinkedList<>();
        mergedList.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (mergedList.getLast()[1] < intervals[i][0]) {
                mergedList.add(intervals[i]);
            } else {
                mergedList.getLast()[1] = Math.max(mergedList.getLast()[1], intervals[i][1]);
            }
        }
        int[][] res = new int[mergedList.size()][2];
        for (int k = 0; k < mergedList.size(); k++) {
            res[k] = mergedList.get(k);
        }
        return res;
    }


    @Test
    public void test1() {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] mergedIntervals = merge(intervals);
        for (int[] interval : mergedIntervals) {
            System.out.println("[" + interval[0] + " , " + interval[1] + "]");
        }
    }

    @Test
    public void test2() {
        int[][] intervals = {{1, 4}, {4, 5}};
        int[][] mergedIntervals = merge(intervals);
        for (int[] interval : mergedIntervals) {
            System.out.println("[" + interval[0] + " , " + interval[1] + "]");
        }
    }

    @Test
    public void test3() {
        int[][] intervals = {{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        int[][] mergedIntervals = merge(intervals);
        for (int[] interval : mergedIntervals) {
            System.out.println("[" + interval[0] + " , " + interval[1] + "]");
        }
    }
}
