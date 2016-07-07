package cn.ssy.argorithms.skiplist;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created with IntelliJ IDEA
 * Author: huangqian
 * Date: 16/7/6
 * Time: 下午10:15
 *
 * 跳跃表
 */
public class SkipList<E extends Comparable<E>> {

    private SLNode<E> head;
    private int maxLevel;
    private int size;
    private Random random;

    public SkipList() {
	this.head = new SLNode<E>(null);
	this.size = 0;
	this.maxLevel = 1;
	this.random = new Random();
    }


    /***
     * 获取搜索路径栈
     * @param e 搜索的元素
     * @return 返回搜索e的每个转折点得元素组成的栈
     */
    public LinkedList<SLNode<E>> getFindPathStack(E e){
	LinkedList<SLNode<E>> findStack = new LinkedList<SLNode<E>>();
	SLNode<E> cursor = this.head;
	while(true){
	    while (cursor.hasNext()
		    && cursor.next.hasData()
		    && cursor.next.data.compareTo(e) <= 0) {
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
     * @param e 被添加的元素
     */
    public synchronized void add(E e){
	LinkedList<SLNode<E>> findStack = getFindPathStack(e);
	SLNode<E> cursor = findStack.peek();
	if(cursor.hasData() && cursor.data.compareTo(e) == 0){//相同的元素直接覆盖
	    cursor.data = e;
	}else{//不同的元素

	    SLNode<E> bottom = null;
	    int level = random.nextInt(maxLevel + 1) + 1;
	    int i = 1;
	    while(!findStack.isEmpty()&& (cursor = findStack.pop()) != null && i <= level) {
		bottom = insertNode(e, cursor, bottom);
		i++;
	    }
	    //层数超出最大曾
	    while(i <= level){
		cursor = new SLNode<E>(null);
		cursor.bottom = this.head;
		this.head = cursor;
		bottom = insertNode(e, cursor, bottom);
		i++;
	    }
	    this.maxLevel = Math.max(level, maxLevel);
	}
	this.size++;
    }

    /***
     * 判断一个元素是否存在
     * @param e 被判断的元素
     * @return 如果跳跃表中已经存在元素e,那么返回true,否则返回false;
     */
    public boolean contains(E e){
	if(e == null)
	    return false;
	LinkedList<SLNode<E>> findStack = getFindPathStack(e);
	SLNode<E> node = findStack.peek();
	return node.hasData() && node.data.equals(e);
    }

    /***
     * 获取指定元素的跳跃表节点
     * @param e 元素
     * @return 如果元素e在跳跃表中存在,那么返回data=e的SLNode,否则返回null
     */
    public SkipList<E>.SLNode<E> getSLNode(E e){
	if( e == null)
	    return null;
	LinkedList<SLNode<E>> findStack = getFindPathStack(e);
	SLNode<E> node = findStack.peek();
	return node.hasData() && node.data.equals(e) ? node : null;
    }

    public ArrayList<E> getDataList(){
	SLNode<E> cursor = this.head;
	while(cursor.hasBottom()){
	    cursor = cursor.bottom;
	}
	ArrayList<E> arrayList = new ArrayList<E>();

	while(cursor.hasNext()){
	    arrayList.add(cursor.next.data);
	    cursor = cursor.next;

	}
	return arrayList;
    }

    private SLNode<E> insertNode(E e, SLNode<E> cursor, SLNode<E> bottom) {
	SLNode<E> newNode = new SLNode<E>(e);
	newNode.next = cursor.next;
	cursor.next = newNode;
	newNode.prev = cursor;
	if(newNode.hasNext()){
	    newNode.next.prev = newNode;
	}
	newNode.bottom = bottom;
	return newNode;
    }


    class SLNode<E extends Comparable<E>>{
	E data;
	SLNode<E> next;
	SLNode<E> prev;
	SLNode<E> top;
	SLNode<E> bottom;

	public SLNode(E data) {
	    this.data = data;
	}

	protected boolean hasNext(){
	    return this.next != null;
	}

	protected boolean hasBottom(){
	    return this.bottom != null;
	}

	protected boolean hasData(){
	    return this.data != null;
	}

    }

}
