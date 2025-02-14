package lesson4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

//imports: cmd+shift+o

public class Application {

	public static void main(String[] args) {
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		
		//gets removed later on
		list1.add(10);
		
		ArrayList<Integer> newList = new ArrayList<Integer>();	
		
		newList.add(10);
		
		//remove 10 from list1
		list1.removeAll(newList);
		
		System.out.println(list1);
		
		//to clear the list
		//list1.clear();
		
		boolean containsValue = list1.contains(1);
		
		System.out.println("does list1 contain value 10: " + containsValue);

		boolean isList1Empty = list1.isEmpty();
		
		int sizeList1 = list1.size();

		System.out.println("is list 1 empty: " 
		+ isList1Empty + ". List1 contains: " + sizeList1 + " elements");
		

		//also method retain all: specify what i want to retain. 
		
		//list1.retainAll(newList);
		
		 HashSet<String> hashSet = new HashSet<String>();
		 
		 hashSet.add("random");
		 hashSet.add("clothes");
		 hashSet.add("computer");
		 
		 ArrayList<String> myList = new	ArrayList<String>(hashSet);
		 
		 Collections.sort(myList);
		 
		 System.out.println(myList);
		
		 
			//minute 06:30
			// populates List with list1               argument of constructor
			List<Integer> li = new ArrayList<Integer>(list1);
			
			////////////////////////////////////////////////////////////////
			
			 HashSet<Integer> hashSet2 = new HashSet<Integer>();
			 
			 hashSet2.add(1);
			 hashSet2.add(2);
			 hashSet2.add(3);
			 hashSet2.add(6);
			 hashSet2.add(5);
			 hashSet2.add(4);


			 ArrayList<Integer> myList2 = new ArrayList<Integer>(hashSet2);
			 
			 Collections.sort(myList2);
			 
			 //prints ordered list from hashSet2
			 System.out.println(myList2);
			 
			 //////
			 
			 // sort user defined elements/objects
			 //implement comparable interface
			 
			 HashSet<Employee> employees = new HashSet<Employee>();
			 
			 employees.add(new Employee ("peter", 1000, "marketing"));
			 employees.add(new Employee ("anna", 2000, "IT"));
			 employees.add(new Employee ("vivian", 3000, "sales"));
			 
			 ArrayList<Employee> myListEmployees = new ArrayList<Employee>(employees);
			 
			 // with custom sort method.
			 Collections.sort(myListEmployees);
			 
			 System.out.println(myListEmployees);
			
			
	}
	

}
