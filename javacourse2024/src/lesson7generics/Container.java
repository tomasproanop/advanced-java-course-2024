package lesson7generics;

// example of generic class

//to work with any desired type, it works with objects!!!
//public class Container<Object, Object>

//now, this is class is really generic!!
public class Container<i1, i2> {
	
//	Object item1;
//	Object item2;
	
	i1 item1;
	i2 item2;
	
	//public Container(Object item1, Object item2) {
	public Container(i1 item1, i2 item2) {

		this.item1 = item1;
		this.item2 = item2;
	}
	
	public i1 getItem1() {
		return item1;
	}

	public void setItem1(i1 item1) {
		this.item1 = item1;
	}

	public i2 getItem2() {
		return item2;
	}

	public void setItem2(i2 item2) {
		this.item2 = item2;
	}

	public void printItems() {
		System.out.println("Printing Contents of container: ");
		System.out.println("item 1: " + item1);
		System.out.println("item 2: " + item2);

	}

}
