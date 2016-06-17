package cn.ssy.argorithms.sort;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA
 * Author: huangqian
 * Date: 16/6/17
 * Time: 下午10:30
 */
public class Sorts {

    /***
     * 选择排序.
     * 	首先,找到数组中最小的那个元素,其次,将它和数组的第一个元素交换位置(如果第一个元素是最小元素那么它就和自己交换).
     * 	再次,在剩下的元素中找到最小的元素,将它与数组的第二个元素交换位置. 如此往复,知道将整个数组排序.
     * @param array 待排序数组
     * @param <T> 数组元素类型
     */
    public static <T extends Comparable<T>>  void selectionSort(T[] array){
	//如果是空数组,那么直接返回
	if( array == null) return;

	for(int i = 0; i < array.length; i++){
	    int min = i;
	    for(int j = i + 1 ; j < array.length; j++){
		if(less(array[j],array[min])){
		    min = j;
		}
	    }
	    if(min != i){
		swap(array, i, min);
	    }
	}
    }


    /***
     * 插入排序
     * 	插入排序由N-1趟排序组成.
     * 	对于P=1趟到P=N-1趟,插入排序保证位置0到位置P上的元素为已排序状态.
     * 	在第P趟,我们将位置P上的元素向左移动到它在前P+1个元素的正确位置.
     * @param array 待排序数组
     * @param <T> 数组元素类型
     */
    public static <T extends Comparable<T>> void insertionSort(T[] array){
	if( array == null) return;
	for(int i = 1; i < array.length; i++){
	    int p = i;
	    //选找插入的位置
	    for(int j = 0; j < i; j++){
		if(less(array[i],array[j])){
		    p = j;
		    break;
		}
	    }
	    //插入数据到数组中
	    T t = array[i];
	    for(int k = i ; k > p; ){
		array[k] = array[--k];
	    }
	    array[p] = t;
	}

    }



    private static <T extends Comparable<T>> boolean less( T a, T b){
	return !(a == null || b == null) && b.compareTo(a) > 0 ;
    }

    private static <T> void swap(T[] arr, int idx1, int idx2){
	T t = arr[idx1];
	arr[idx1] = arr[idx2];
	arr[idx2] = t;
    }


}
