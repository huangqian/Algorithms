package argorithms.sort;

/**
 * 快速排序
 * Created with IntelliJ IDEA
 * Author: huangqian
 * Date: 16/6/21
 * Time: 上午7:22
 */
public class QuickSort {

    private static int CUT_OFF = 3;

    /***
     * 三数中值法获取分割的枢纽元
     * @param array 待排序数组
     * @param left 待排序区间的最小索引
     * @param right 待排序区间的最大索引
     * @param <T> 待排序元素的类型
     * @return 返回 low, (low + high) / 2, high三个数的中值作为分割枢纽元
     */
    public static <T extends Comparable<T>> T median3(T[] array, int left, int right){
	int center = (left + right) / 2;		//中间位置
	if(Sorts.less(array[right], array[left])){//leetcode.array[low] > leetcode.array[high]
	    Sorts.swap(array, left, right);
	}
	if(Sorts.less(array[center], array[left])){ // leetcode.array[low] > leetcode.array[center]
	    Sorts.swap(array, left, center);
	}
	if(Sorts.less(array[right], array[center])){// leetcode.array[center] > leetcode.array[high]
	    Sorts.swap(array, center, right);
	}
	//将枢纽元素放在第一个位置,并且返回
	Sorts.swap(array, left, center);
	return array[left];
    }

    public static <T extends Comparable<T>> void sort(T[] array, int left, int right){
	if(left + CUT_OFF <= right){
	    T key = median3(array, left, right);
	    int i = left;
	    int j = right;
	    for(; ;){
		while(i < j && Sorts.less(array[++i], key)){}
		while(i < j && Sorts.less(key, array[--j])){}
		if(i < j){
		    Sorts.swap(array, i ,j);
		}else{
		    break;
		}
	    }
	    //将枢纽元放在正确的位置
	    Sorts.swap(array,left,i - 1);

	    sort(array, left, i);
	    sort(array, i+1, right);
	}else{
	    //小数组转为插入排序,小数组中插入排序比快速排序更优
	    Sorts.insertionSort(array, left, right);
	}
    }

    public static <T extends Comparable<T>> void sort(T[] array){
	sort(array,0,array.length -1);
    }
}
