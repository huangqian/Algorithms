package argorithms.skiplist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA
 * Author: huangqian
 * Date: 16/7/7
 * Time: 下午10:57
 */
public class SkipListMap<K extends Comparable<K>,V> {


    private SLEntry<K,V> head;
    private int maxLevel;
    private int size;
    private Random random;

    public SkipListMap() {
	this.head = new SLEntry<K,V>(null,null);
	this.size = 0;
	this.maxLevel = 1;
	this.random = new Random();
    }


    /***
     * 获取搜索路径栈
     * @param key 搜索的key
     * @return 返回搜索e的每个转折点得元素组成的栈
     */
    public LinkedList<SLEntry<K,V>> getFindPathStack(K key){
	LinkedList<SLEntry<K,V>> findStack = new LinkedList<SLEntry<K,V>>();
	SLEntry<K,V> cursor = this.head;
	while(true){
	    while (cursor.hasNext()
		    && cursor.next.hasKey()
		    && cursor.next.key.compareTo(key) <= 0) {
		cursor = cursor.next;
	    }
	    findStack.push(cursor);
	    if(cursor.hasBottom()) {
		cursor = cursor.bottom;
	    }else{
		break;
	    }
	}
	return findStack;
    }

    /***
     * 向跳跃表中添加一个元素
     * @param key 添加的键
     * @param value 添加的值
     */
    public synchronized V put(K key, V value){
	LinkedList<SLEntry<K,V>> findStack = getFindPathStack(key);
	SLEntry<K,V> cursor = findStack.peek();
	if(cursor.hasKey() && cursor.key.compareTo(key) == 0){//相同的元素直接覆盖
	    V oldValue = cursor.value;
	    cursor.value = value;
	    return oldValue;
	}else{//不同的元素

	    SLEntry<K,V> bottom = null;
	    int level = random.nextInt(maxLevel + 1) + 1;
	    int i = 1;
	    while(!findStack.isEmpty()&& (cursor = findStack.pop()) != null && i <= level) {
		bottom = insertNode(key, value, cursor, bottom);
		i++;
	    }
	    //层数超出最大曾
	    while(i <= level){
		cursor = new SLEntry<K,V>(null, null);
		cursor.bottom = this.head;
		this.head = cursor;
		bottom = insertNode(key, value, cursor, bottom);
		i++;
	    }
	    this.maxLevel = Math.max(level, maxLevel);
	}
	this.size++;
	return null;
    }

    /***
     * 判断一个元素是否存在
     * @param key 键
     * @return 如果跳跃表中已经存在键key,那么返回true,否则返回false;
     */
    public boolean containsKey(K key){
	if(key == null)
	    return false;
	LinkedList<SLEntry<K,V>> findStack = getFindPathStack(key);
	SLEntry<K,V> entry = findStack.peek();
	return entry.hasKey() && entry.key.equals(key);
    }


    public V get(K key){
	if( key == null)
	    return null;
	LinkedList<SLEntry<K,V>> findStack = getFindPathStack(key);
	SLEntry<K,V> entry = findStack.peek();
	return entry.hasKey() && entry.key.equals(key) ? entry.value : null;
    }

    private SLEntry<K,V> insertNode(K key, V value, SLEntry<K,V> cursor, SLEntry<K,V> bottom) {
	SLEntry<K,V> newNode = new SLEntry<K,V>(key, value);
	newNode.next = cursor.next;
	cursor.next = newNode;
	newNode.prev = cursor;
	if(newNode.hasNext()){
	    newNode.next.prev = newNode;
	}
	newNode.bottom = bottom;
	return newNode;
    }

    public List<SLEntry<K,V>> entryList(){
	SLEntry<K,V> cursor = this.head;
	while(cursor.hasBottom()){
	    cursor = cursor.bottom;
	}
	ArrayList<SLEntry<K,V>> arrayList = new ArrayList<SLEntry<K,V>>();
	while(cursor.hasNext()){
	    cursor = cursor.next;
	    arrayList.add(cursor);
	}
	return arrayList;
    }



    class SLEntry<K extends Comparable<K>,V>{
	K key;
	V value;
	SLEntry<K,V> next;
	SLEntry<K,V> prev;
	SLEntry<K,V> top;
	SLEntry<K,V> bottom;

	public SLEntry(K key, V value) {
	    this.key = key;
	    this.value = value;
	}

	public SLEntry<K,V> next(){
	    return next;
	}

	protected boolean hasNext(){
	    return this.next != null;
	}

	protected boolean hasBottom(){
	    return this.bottom != null;
	}

	protected boolean hasKey(){
	    return this.key != null;
	}

    }
}
