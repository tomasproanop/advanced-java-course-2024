package lesson7generics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//generics and use of iterator
public class Application {

	public static void main(String[] args) {

		//ArrayList is raw type: anything can be passed here: string int, etc.
		//different data types
		
		ArrayList myList = new ArrayList();
		myList.add("hi");
		myList.add(5);
		myList.add(true);
		
		// casting is needed !!
		String myval1 = (String) myList.get(0);
	
	
	//not specific
	//Container container = new Container(12, "Hi");

	//now it is specific, parameterized types.
	Container<Integer, String> container = new Container<>(12, "Hi");
	int val1 = container.getItem1();
	
	// not type safe -> thus add angle brackets in container class. 
	//Object myVar = (String) container.getItem1();
	
	//////
	
	String val2 = container.getItem2();
	
	Set<String> mySet1 = new HashSet<String>();
	mySet1.add("first s1");
	mySet1.add("second s1");
	mySet1.add("third s1");
	
	Set<String> mySet2 = new HashSet<String>();
	mySet2.add("first s2");
	mySet2.add("second s2");
	mySet2.add("third s2");

	Set<String> resultSet = union(mySet1, mySet2);
	System.out.println(resultSet);
	
	//iterator is also type-safe
	
	Iterator<String> iteratorForSet = resultSet.iterator();
	
	while(iteratorForSet.hasNext()) {
		System.out.println(iteratorForSet.next());
	}


}

// now, example for a generic method

public static <E> Set<E> union(Set<E> set1, Set<E> set2) {
	
	Set<E> result = new HashSet<E>(set1);
	
	//contains data for both of these sets , with addAll Method
	result.addAll(set2);
	return result;
}

}
