package argorithms.sort;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA
 * Author: huangqian
 * Date: 16/6/17
 * Time: 下午11:10
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class SortsExample {

    static class User implements Comparable<User>{

	private String name;
	private int age;

	public User(String name, int age) {
	    this.name = name;
	    this.age = age;
	}

	public String getName() {
	    return name;
	}

	public void setName(String name) {
	    this.name = name;
	}

	public int getAge() {
	    return age;
	}

	public void setAge(int age) {
	    this.age = age;
	}

	public int compareTo(User other) {

	    return other == null ? 1 : this.age - other.getAge();
	}

	@Override
	public String toString() {
	    return "User{" +
		    "name='" + name + '\'' +
		    ", age=" + age +
		    '}';
	}
    }

    @Test
    public void testSelectionSort(){
	Integer[] array = new Integer[]{ 100, 76, 1 , 45 , 33, 89 , 0};
	Integer[] result = new Integer[]{0, 1, 33, 45, 76, 89, 100};
	Sorts.selectionSort(array);
	for(int i : array){
	    System.out.print( i + " ");
	}
	Assert.assertArrayEquals(result,array);
    }


    @Test
    public void testObjSelectionSort(){
	User[] users = new User[]{ new User("Jerry", 28), new User("Mark", 56), new User("John", 18)};
	System.out.println("排序前:");
	for(User user : users){
	    System.out.println(user);
	}
	Sorts.selectionSort(users);
	System.out.println("排序后:");
	for(User user : users){
	    System.out.println(user);
	}
    }



    @Test
    public void testInsertionSort(){
	Integer[] array = new Integer[]{ 100, 76, 1 , 45 , 33, 89 , 0};
	Integer[] result = new Integer[]{0, 1, 33, 45, 76, 89, 100};
	Sorts.insertionSort(array);
	System.out.println("插入排序:");
	for(int i : array){
	    System.out.print(i + " ");
	}
	Assert.assertArrayEquals(result,array);
    }

    @Test
    public void testObjInsertionSort(){
	User[] users = new User[]{ new User("Jerry", 28), new User("Mark", 56), new User("John", 18)};
	System.out.println("排序前:");
	for(User user : users){
	    System.out.println(user);
	}
	Sorts.insertionSort(users);
	System.out.println("排序后:");
	for(User user : users){
	    System.out.println(user);
	}
    }

    @Test
    public void testShellSort(){
	Integer[] array = new Integer[]{ 100, 76, 1 , 45 , 22, 33, 89 , 0};
	Integer[] result = new Integer[]{0, 1, 22 , 33, 45, 76, 89, 100};
	Sorts.shellSort(array);
	System.out.println("希尔排序:");
	for(int i : array){
	    System.out.print(i + " ");
	}
	Assert.assertArrayEquals(result,array);
    }

    @Test
    public void testQuickSort(){
	Integer[] array = new Integer[]{ 100, 76, 1 , 45 , 22, 33, 89 , 0};
	Integer[] result = new Integer[]{0, 1, 22 , 33, 45, 76, 89, 100};
	QuickSort.sort(array);
	System.out.println("快速排序:");
	for(int i : array){
	    System.out.print(i + " ");
	}
	//Assert.assertArrayEquals(result, array);
    }
}
