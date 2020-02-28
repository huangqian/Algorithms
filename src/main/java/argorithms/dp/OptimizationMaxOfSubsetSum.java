package argorithms.dp;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/2/12 - 08:08
 * @description: 在一个数组中，不能选择相邻的数字，如果将取出的数字之和最大
 */
public class OptimizationMaxOfSubsetSum {

    public static void main(String[] args) {

        int[] arr = {1, 2, 4, 1, 7, 8, 3};
        System.out.println("getOptimizationByRecursive at 6 optimization=" + getOptimizationByRecursive(arr, 6));

        System.out.println("getOptimizationByIterator at 6 optimization=" + getOptimizationByIterator(arr)[6]);
    }

    /**
     * 通过递归实现
     */
    public static int getOptimizationByRecursive(int[] arr, int index) {

        switch (index) {
            case 0:
                return arr[0];
            case 1:
                return Math.max(arr[0], arr[1]);
            default:
                break;
        }

        //判断这种情况就是当前index对应的是否被选中的倒退，从后往前推。类似分支的思想。
//        int selectedIndexOpt = getOpt(arr, index - 2) + arr[index];
//        int unselectedIndexOpt = getOpt(arr, index - 1);
//        return Math.max(unselectedIndexOpt, selectedIndexOpt);
        return Math.max(getOptimizationByRecursive(arr, index - 1),
                getOptimizationByRecursive(arr, index - 2) + arr[index]);
    }

    public static int[] getOptimizationByIterator(int[] arr) {
        int[] optimizations = new int[arr.length];
        optimizations[0] = arr[0];
        optimizations[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            optimizations[i] = Math.max(optimizations[i - 1], optimizations[i - 2] + arr[i]);
        }
        return optimizations;
    }
}
