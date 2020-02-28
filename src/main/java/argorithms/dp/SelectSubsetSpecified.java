package argorithms.dp;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/2/12 - 09:00
 * @description: 判断下面数组中，是否存在其中的几个元素之和等于指定的值
 */
public class SelectSubsetSpecified {

    public static void main(String[] args) {

        int[] arr = {3, 34, 4, 12, 5, 2};
        int spec = 9;

        System.out.println(hasSubsetByRecursive(arr, arr.length - 1, 9));
        System.out.println(hasSubsetByRecursive(arr, arr.length - 1, 10));
        System.out.println(hasSubsetByRecursive(arr, arr.length - 1, 11));
        System.out.println(hasSubsetByRecursive(arr, arr.length - 1, 12));
        System.out.println(hasSubsetByRecursive(arr, arr.length - 1, 13));
    }

    public static boolean hasSubsetByRecursive(int[] arr, int index, int spec) {
        //直接找到了
        if (spec == 0) {
            return true;

        } else if (index == 0) {
            //最有最后一个了，判断最后一个原始是否等于spec
            return arr[index] == spec;
        } else if (arr[index] > spec) {
            //如果当前值大于spec直接不选择
            return hasSubsetByRecursive(arr, index - 1, spec);
        } else {
            return hasSubsetByRecursive(arr, index - 1, spec - arr[index])
                    || hasSubsetByRecursive(arr, index - 1, spec);
        }
    }
}
