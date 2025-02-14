package lesson5;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Application {
	public static void main(String[] args) {
		// implements map interface
		HashMap<String, String> dictionary = new HashMap<String, String>();
		// uses method put instead of add.
		dictionary.put("cat", "definition of cat :)");
		dictionary.put("dog", "definition of dog :)");
		dictionary.put("bird", "definition of bird :)");
		dictionary.put("hamster", "definition of hamster :)");

		// no order
		for (String word : dictionary.keySet()) {
			System.out.println(word);
		}

		System.out.println("////////////////////////////////");
		
		// linked hasmhmap would preserve order

		LinkedHashMap<String, String> dictionary2 = new LinkedHashMap<String, String>();
		// uses method put instead of add.
		dictionary2.put("cat", "definition of cat :)");
		dictionary2.put("dog", "definition of dog :)");
		dictionary2.put("bird", "definition of bird :)");
		dictionary2.put("hamster", "definition of hamster :)");

		//alternative: dictionary.value: loop over the values

		// order of nouns is maintained
		for (String word2 : dictionary2.keySet()) {
			System.out.println(word2);

		}
		
		
		System.out.println("////////////////////////////////");

		//print definitions
		for (String word2 : dictionary2.keySet()) {
			System.out.println(dictionary2.get(word2));

		}
		
		for(Map.Entry<String, String> entry : dictionary.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
		// sort in alphabetical order
		//cannot have duplicates. 
		//override hashcode and equals. 
		
		System.out.println("////////////////////////////////");

		TreeMap<String, String> dictionary3 = new TreeMap<String, String>();
		// uses method put instead of add.
		dictionary3.put("cat", "definition of cat :)");
		dictionary3.put("dog", "definition of dog :)");
		dictionary3.put("bird", "definition of bird :)");
		dictionary3.put("hamster", "definition of hamster :)");
		dictionary3.put("hamster", "definition of hamster :)");

		
		for(Map.Entry<String, String> entry : dictionary3.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
	}
}
