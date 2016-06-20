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
	    moveToLeft(array,i,p);
//	    T t = array[i];
//	    for(int k = i ; k > p; ){
//		array[k] = array[--k];
//	    }
//	    array[p] = t;
	}

    }


    /***
     * 希尔排序
     * 	希尔排序是一种改进的插入排序.它是通过一定间隔的元素来工作;各趟比较所用的距离随着算法的进行减小,知道指教相邻的元素的最后一趟为止.
     * 	希尔排序的比较的距离也叫增量序列.有一种流行(但是不好)的选择是使用shell推荐的学列:h0 = arr.length/2和 h(k) = h(k+1)/2
     * @param array 待排序数组
     * @param <T> 数组元素类型
     */
    public static <T extends Comparable<T>> void shellSort(T[] array){
	if(array == null) return;
	//构造增量因子
	int h = array.length / 2;
	while(h >= 1){

	    for(int n = 0; n < h ; n++) {
		//每次选择间隔h的元素进行插入排序
		for (int i = n + h; i < array.length; i += h) {
		    int p = i;
		    for (int j = n; j < i; j += h) {
			if (less(array[i], array[j])) {
			    {
				p = j;
				break;
			    }
			}
		    }
		    //插入
		    moveToLeft(array,i,p,h);
//		    T t = array[i];
//		    int nextPointer ;
//		    for (int k = i; k > p; k -= h){
//			nextPointer = k -h;
//			array[k] = array[nextPointer];
//		    }
//		    array[p] = t;
		}
	    }
	    //重新计算增量因子
	    h = h/2;
	};

    }



    public static <T extends Comparable<T>> boolean less( T a, T b){
	return !(a == null || b == null) && b.compareTo(a) > 0 ;
    }

    private static <T> void swap(T[] arr, int idx1, int idx2){
	T t = arr[idx1];
	arr[idx1] = arr[idx2];
	arr[idx2] = t;
    }

    private static <T> void moveToLeft(T[] array,int sourcePointer, int distPointer){
	moveToLeft(array,sourcePointer,distPointer,1);
    }

    private static <T> void moveToLeft(T[] array, int sourcePointer, int distPointer, int step){
	T t = array[sourcePointer];
	int nextPointer ;
	for (int k = sourcePointer; k > distPointer; k -= step){
	    nextPointer = k -step;
	    array[k] = array[nextPointer];
	}
	array[distPointer] = t;
    }


}
