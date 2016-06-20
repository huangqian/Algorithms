package cn.ssy.argorithms.sort;

import java.util.Arrays;

/**
 * 归并排序
 * Created with IntelliJ IDEA
 * Author: huangqian
 * Date: 16/6/19
 * Time: 下午10:56
 */
public class MergeSort {

    /***
     * 归并
     * @param array 需要归并的数组
     * @param low 数据最小位置索引
     * @param mid 中间部分的索引
     * @param high 最大的索引
     * @param <T> 数组元素类型
     */
    public static <T extends Comparable<T>> void merge(T[] array, int low, int mid, int high, T[] aux){
	if(low >= high) return;
	int left = low;//左半边指针
	int right = mid + 1;//右半边指针

	for(int k = low; k <= high; k++){
	    if(left > mid){//左半边用尽,将右边的元素合并到结果上
		aux[k] = array[right];
	    }else if(right > high){//右半边元素用尽,将左边元素合并到结果上
		aux[k] = array[left++];
	    }else if(Sorts.less(array[left],array[right])){//如果左边当前指针指向的元素小于右边指针指向的元素
		aux[k] = array[left++];
	    }else{
		aux[k] = array[right++];
	    }
	}
	//复制排序好的内容
	System.arraycopy(aux, low, array, low, high - low + 1 );

    }


    //自顶向下的合并排序
    public static <T extends Comparable<T>> void sort(T[] array, int low, int high, T[] aux){
	if(array == null || low >= high) return;
	//计算中间位置
	int mid = (low + high) / 2;
	//将数组一分为二进行排序
	//左半边元素排序,递归
	sort(array, low, mid, aux);
	//右半边排序,递归
	sort(array, mid + 1, high, aux);
	//合并
	merge(array, low, mid, high, aux);
    }

    //自顶向下的排序
    public static <T extends Comparable<T>> void sort(T[] array){
	if(array == null) return;
	//将原始数组复制一份,用于归并,原数组存储归并结果
	T[] aux = Arrays.copyOf(array,array.length);
	sort(array, 0 ,array.length - 1,aux);
    }

}
