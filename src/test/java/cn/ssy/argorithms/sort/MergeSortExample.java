package cn.ssy.argorithms.sort;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA
 * Author: huangqian
 * Date: 16/6/19
 * Time: 下午11:41
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class MergeSortExample {

    /***
     * 测试自顶向下的合并排序
     */
    @Test
    public void testTopToDownMergeSort(){
	Integer[] array = new Integer[]{10000, 300, 2759878, 12, 89080, 32, 4221423, 21, 5434, 423189, 44, 100, 1, 3422341, 9 };
	MergeSort.sort(array);
	System.out.println("合并排序:");
	for(Integer element : array){
	    System.out.println(element);
	}
    }

    @Test
    public void testSorts(){
	Integer[] array = new Integer[]{10000, 300, 2759878, 12, 89080, 32, 4221423};
	MergeSort.sorts(array);
	System.out.println("合并排序:");
	for(Integer element : array){
	    System.out.println(element);
	}
    }
}
