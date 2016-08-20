package argorithms.skiplist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Author: huangqian
 * Date: 16/7/7
 * Time: 下午5:25
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class SkipListTestCase {



    @Test
    public void testSkipListAdd(){
	SkipList<Integer> skipList = new SkipList<Integer>();
	skipList.add(100);
	skipList.add(20);
	skipList.add(500);
	skipList.add(325);
	skipList.add(1);
	skipList.add(3);
	List<Integer> dataList = skipList.getDataList();
	for(Integer val : dataList){
	    System.out.println(val);
	}

    }

    @Test
    public void testSkipListMap(){
	SkipListMap<Integer,String> skipListMap = new SkipListMap<Integer, String>();
	skipListMap.put(100,"壹佰");
	skipListMap.put(20,"贰拾");
	skipListMap.put(500,"伍佰");
	skipListMap.put(325,"叁佰贰拾伍");
	skipListMap.put(1,"壹");
	skipListMap.put(3,"叁");

	List<SkipListMap<Integer,String>.SLEntry<Integer,String>> entryList = skipListMap.entryList();
	for(SkipListMap<Integer,String>.SLEntry<Integer,String> entry : entryList){
	    System.out.println(entry.key + "=" + entry.value);
	}
    }
}
