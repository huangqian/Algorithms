package argorithms.tree;

/**
 * Created with IntelliJ IDEA
 * Author: huangqian
 * Date: 2016-08-20
 * Time: 15:26
 *
 * 二叉搜索树的迭代实现
 */
public class BinarySearchTreeIterativeImpl<K extends Comparable<K>,V> extends BinarySearchTree<K,V>{
    /***
     * this tree node numbers
     *
     * @return node numbers
     */
    public int size() {
	return 0;
    }


    private BSTNode<K,V> find(K key){
	BSTNode<K,V> cursor = root;
	int cps;
	while(cursor != null){
	    cps = key.compareTo(cursor.getKey());
	    if(cps == 0) {
		return cursor;
	    }else if(cps < 0){
		cursor = cursor.getLeft();
	    }else {
		cursor = cursor.getRight();
	    }

	}
	return null;
    }


    public V get(K key) {
	BSTNode<K,V> node = find(key);
	if(node != null)
	    return node.getValue();
	return null;
    }



    public void put(K key, V value){
	BSTNode<K,V> cursor = root;
	BSTNode<K,V> parent = root;
	int cps = 0;
	//确定插入的位置
	while(cursor != null){
	    cps = key.compareTo(cursor.getKey());
	    if(cps == 0){
		break;
	    }else if(cps < 0){
		parent = cursor;
		cursor = cursor.getLeft();
	    }else{
		parent = cursor;
		cursor = cursor.getRight();
	    }
	}
	//插入数据
	if(cursor != null){
	    cursor.setValue(value);
	    return;
	}
	cursor = BSTNode.of(key, value);
	if(cps == 0){
	    root = cursor;
	}else if(cps < 0){
	    parent.setLeft(cursor);
	}else {
	    parent.setRight(cursor);
	}
    }


    public void put1(K key, V value) {
	if(root == null){
	    root = BSTNode.of(key,value);
	    return;
	}
	BSTNode<K,V> cursor = root;
	int cps ;
	while(cursor != null){
	    cps = key.compareTo(cursor.getKey());
	    if(cps == 0){
		cursor.setValue(value);
		return ;
	    }else if (cps < 0){
		if(cursor.hasLeft()) {
		    cursor = cursor.getLeft();
		}else {
		    cursor.setLeft(BSTNode.of(key,value));
		    return;
		}
	    }else{
		if(cursor.hasRight()){
		    cursor = cursor.getRight();
		}else{
		    cursor.setRight(BSTNode.of(key,value));
		    return;
		}
	    }
	}
    }
}
