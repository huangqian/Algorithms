package argorithms.tree;

/**
 * Created with IntelliJ IDEA
 * Author: huangqian
 * Date: 2016-08-20
 * Time: 14:41
 *
 * 递归方式的实现
 */
public class BinarySearchTreeRecursiveImpl<K extends Comparable<K>,V> extends BinarySearchTree<K,V> {

    /**
     * 搜索指定key对应的节点
     *
     * @param key 搜索的键
     * @return 如果key对应的节点存储,那么返回对应的节点,否则返回null
     */
    private BSTNode<K,V> find(K key){
	return find(this.root, key);
    }

    /***
     * 从指定子树节点搜索key对应的节点
     *
     * @param root 指定的子树根节点
     * @param key 搜索的key
     * @return 如果当前节点是空节点,则直接返回null,
     * 如果当前节点的key和搜索的key相等,那么返回当前节点;
     * 如果大于当前节点,则在当前节点的右子树上进行搜索
     * 如果小于当前节点,则在当前节点的左子树上进行搜索
     */
    private BSTNode<K,V> find(BSTNode<K,V> root, K key){
	if(root == null)
	    return null;
	int cps = key.compareTo(root.getKey());
	if(cps == 0){
	    return root;
	}else if(cps < 0){ //小于当前节点,去左子树搜索
	    return find(root.getLeft(),key);
	}else{ //大于当前节点的值,去该节点的右子树搜索
	    return find(root.getRight(), key);
	}
    }



    /***
     * this tree node numbers
     *
     * @return node numbers
     */
    @Override
	public int size() {
	return size(root);
    }

    private int size(BSTNode<K,V> node){
	if(node == null) {
		return 0;
	}
	return size(node.getLeft()) + size(node.getRight()) + 1;
    }

    /***
     * 根据指定的key获取其对应的值
     * @param key 搜索的key
     * @return 如果key对应的节点存在,则返回key对应的值,否则返回null
     */
    public V get(K key) {
	BSTNode<K,V> node = find(key);
	if(node != null)
	    return node.getValue();
	return null;
    }

    private BSTNode<K,V> put(BSTNode<K,V> cursor, K key, V value){
	if(cursor == null){
	    cursor =new BSTNode<K,V>(key, value);
	    return cursor;
	}
	int cps = key.compareTo(cursor.getKey());
	if(cps == 0){
	    cursor.setValue(value);
	    return cursor;
	}else if(cps < 0){
	   return put(cursor.getLeft(), key, value);
	}else {
	    return put(cursor.getRight(), key, value);
	}
    }


    public void put(K key, V value) {
	put(root,key,value);
    }
}
