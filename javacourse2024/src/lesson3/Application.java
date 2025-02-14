package lesson3;

import java.util.ArrayList;
//ctrl+shift+o!!
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Application {

	public static void main(String[] args) {

		// no repeated valuesm does not care about orderm only about unique value
		HashSet<Integer> values = new HashSet<Integer>();
		values.add(5);
		values.add(6);
		values.add(5);
		values.add(7);

		// allows repeated values, mantains order of insertion
		ArrayList<Integer> values2 = new ArrayList<Integer>();
		values2.add(5);
		values2.add(6);
		values2.add(5);
		values2.add(7);

		System.out.println("HashSet");

		for (Integer value : values) {
			System.out.println(value);
		}

		System.out.println();
		System.out.println("################################");
		System.out.println();

		System.out.println("ArrayList");

		for (Integer value : values2) {
			System.out.println(value);
		}

		System.out.println();
		System.out.println("################################");
		System.out.println();
		
		System.out.println("LinkedHashSet");
		
		// no duplicates, ordered
		LinkedHashSet<String> values3 = new LinkedHashSet<String>();

		values3.add("random");
		values3.add("animal");
		values3.add("random");
		values3.add("horse");
		values3.add("cat");
		values3.removeFirst();
		//prints:
		//animal
		//horse
		//cat
	
		
		for (String value : values3) {
			System.out.println(value);
		}
		
		HashSet<Animal> animals = new HashSet<Animal>();
		
		Animal animal1 = new Animal("cat", 3);
		Animal animal2 = new Animal("dog", 3);
		Animal animal3 = new Animal("bird", 3);
		Animal animal4 = new Animal("lizzard", 3);
		Animal animal5 = new Animal("lizzard", 3);

		animals.add(animal1);
		animals.add(animal2);
		animals.add(animal3);
		animals.add(animal4);
		//hascode is different, equality is based on hashcode!
		animals.add(animal5);
		
		for(Animal value : animals) {
			System.out.println(value.toString());
		}
		
		// with "generate" option in class, right click, source...
		System.out.println(animal4.equals(animal5));
		
		//different hashcode without helping method. 
		//with method, they are equal
		System.out.println(animal4.hashCode());
		System.out.println(animal5.hashCode());
		

	}

}
