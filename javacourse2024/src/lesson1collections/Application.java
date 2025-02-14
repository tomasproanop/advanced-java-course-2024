package lesson1collections;

import java.util.ArrayList;
import java.util.LinkedList;

//Introduction to Collections: ArrayList and LinkedList
// the underlying implementation is different
// the idea is the same, they are both lists

public class Application {

	public static void main(String[] args) {
		
		// Java is a type-safe language

		//AL is a resizable array
		
				// wrapper class String
		ArrayList<String> words = new ArrayList<String>();
		
		words.add("hello world");
		words.add("bye");
		
		String word1 = words.get(0);
		String word2 = words.get(1);
		

		System.out.println(word1);
		
		
		

		//LL is bunch of nodes that are linked together
		

		
							//wrapper class Integer
		LinkedList<Integer> numbers = new LinkedList<Integer>();
		numbers.add(4);
		numbers.add(9);
		numbers.add(5);
		numbers.add(6);
		
		int num1 = numbers.get(0);
		int num2 = numbers.get(1);
		
		System.out.println(num1+num2);
		
		for (int number : numbers ) {
			System.out.println(number);
		}
	}

}
