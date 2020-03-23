package leetcode.cache;

import java.util.HashMap;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/4 - 14:49
 * @description: LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * 示例:
 * <p>
 * LRUCache cache = new LRUCache( 2 );
 * <p>
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // 返回  1
 * cache.put(3,3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4,4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * <p>
 * 思路： 双向链表方便增加删除，外加通过hashmap快速定位节点，使得操作时间复杂度全部为O(1)
 */
public class LRUCache {

    static class Entry {
        int key;
        volatile int value;
        Entry next;
        Entry prev;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    public static int NOT_FOUND = -1;

    private HashMap<Integer, Entry> index;
    private Entry head;
    private Entry tail;
    private int size;
    private int capacity;


    public LRUCache(int capacity) {
        index = new HashMap<>(capacity);
        this.head = new Entry(0, 0);
        this.tail = new Entry(0, 0);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    protected void enqueue(Entry entry) {
        Entry last = this.tail.prev;
        entry.prev = this.tail.prev;
        last.next = entry;
        entry.next = tail;
        tail.prev = entry;
    }

    protected void resetEnqueue(Entry entry) {
        Entry pre = entry.prev;
        entry.next.prev = pre;
        pre.next = entry.next;
        enqueue(entry);
    }

    protected void deleteTopK(int k) {
        Entry cur = head;
        for (int i = 0; i < k; i++) {
            cur = cur.next;
            index.remove(cur.key);
        }
        head.next = cur.next;
        cur.next.prev = head;
        size -= k;
    }

    public int get(int key) {
        Entry entry = index.get(key);
        if (entry != null) {
            resetEnqueue(entry);
            return entry.value;
        }
        return NOT_FOUND;
    }

    public int size() {
        return this.size;
    }

    public void put(int key, int value) {
        Entry entry;
        if (index.containsKey(key)) {
            entry = index.get(key);
            entry.value = value;
            resetEnqueue(entry);
        } else {
            this.size++;
            if (size > capacity) {
                deleteTopK(size - capacity);

            }
            entry = new Entry(key, value);
            enqueue(entry);
            this.index.put(key, entry);
        }
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
