package argorithms.tree;

/**
 * Created with IntelliJ IDEA
 * Author: huangqian
 * Date: 2016-08-20
 * Time: 14:19
 *
 * 二叉搜索树
 */
public abstract class BinarySearchTree<K extends Comparable<K>, V> {

    //BinarySearchTree root Node
    protected BSTNode<K,V> root;

    /***
     * this tree node numbers
     *
     * @return node numbers
     */
    public abstract int size();


    public abstract V get(K key);

    public abstract void put(K key, V value);

    /***
     * BinarySearchTree Node class
     *
     * @param <K> type for key parameter, K must be extends Comparable class.
     * @param <V> type for value parameter
     */
    static class BSTNode<K extends Comparable<K>, V>{
	//节点的Key
	private K key;
	//节点的值
	private V value;
	//左子树和右子树的节点
	private BSTNode<K,V> left,right;
	//以当前节点为根节点的子树的节点总数
	private int numberOfChildNodes;

	public K getKey() {
	    return key;
	}

	public void setKey(K key) {
	    this.key = key;
	}

	public V getValue() {
	    return value;
	}

	public void setValue(V value) {
	    this.value = value;
	}

	public BSTNode<K, V> getLeft() {
	    return left;
	}

	public void setLeft(BSTNode<K, V> left) {
	    this.left = left;
	}

	public BSTNode<K, V> getRight() {
	    return right;
	}

	public void setRight(BSTNode<K, V> right) {
	    this.right = right;
	}

	public int getNumberOfChildNodes() {
	    return numberOfChildNodes;
	}

	public void setNumberOfChildNodes(int numberOfChildNodes) {
	    this.numberOfChildNodes = numberOfChildNodes;
	}

	public boolean hasLeft(){
	    return this.left != null;
	}

	public boolean hasRight(){
	    return this.right != null;
	}



	public BSTNode(K key, V value) {
	    this(key, value, null, null, 0);
	}

	public BSTNode(K key, V value, BSTNode<K, V> left, BSTNode<K, V> right, int numberOfChildNodes) {
	    this.key = key;
	    this.value = value;
	    this.left = left;
	    this.right = right;
	    this.numberOfChildNodes = numberOfChildNodes;
	}

	public static <K extends Comparable<K>, V> BSTNode<K,V> of(K key, V value){
	    return new BSTNode<K, V>(key,value);
	}

    }
}
