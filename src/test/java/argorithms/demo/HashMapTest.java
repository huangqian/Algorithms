package argorithms.demo;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/5/12 - 10:10
 * @description:
 */
public class HashMapTest {

    @Test
    public void testJava8ConcurrentHashMapPutNull() {
        ConcurrentHashMap<String, String> hash = new ConcurrentHashMap<>();
        hash.put(null, null);
    }

    @Test
    public void test() {
        System.out.println(-128 % 10);
    }
}
