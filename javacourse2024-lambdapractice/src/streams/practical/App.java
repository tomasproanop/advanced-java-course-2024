package streams.practical;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) throws IOException {
		
		// prints 1-9, with ln
		IntStream
			.range(1, 10) // source
			.forEach((x) -> System.out.println(x));
		
		System.out.println();
		
		
		// IntStream with skip: prints 6-9 with ln
		IntStream
			.range(1, 10) // source
			.skip(5) // skips 5 elements, not inclusive. intermediate operation
			.forEach((x) -> System.out.println(x)); //
		
		System.out.println();
		
		
		// IntStream with sum: prints 
		int val = IntStream
		.range(1, 5) // source
		.sum(); // sums 1+2+3+4 = 10
	
		System.out.println(val);
		
		// Stream.of sorted and findFirst 
		Stream.of("Hello", "Bottle", "Africa")
			.sorted()
			.findFirst() 
			.ifPresent((x) -> System.out.println(x)); // prevents null pointer exception
		
		// Stream from Array, sort, filter and prints the strings starting with letter "t"
		String[] items =  {"car", "computer", "toothpaste", "box", "pencil", "tent", "door", "toy"};
		Stream.of(items)
			.filter((x) -> x.startsWith("t")) 
			.sorted()
			.forEach((x) -> System.out.println(x + ", "));
		
		System.out.println();
		
		
		//average of squares of an integer array
		//prints 7.5
		Arrays.stream(new int[] {1, 2, 3, 4}) // passint array into stream
			.map((x) -> x * x) // values are being mapped to the square
     		.average() // averages of the squares
     		.ifPresent(n -> System.out.println(n)); // prevents null pointer exception
		
		System.out.println();
		
		
		// stream from a list, filter and prints car and computer with lower case characters
		List<String> listOfItems = Arrays.asList("Computer", "Toothpaste", "Box", "Car", "Tent", "Door", "Toy");
		listOfItems.stream()
			.map(x -> x.toLowerCase())
			.filter(x -> x.startsWith("c"))
			.sorted()
			.forEach(x -> System.out.println(x + ", "));
		
		// now, streaming files. 
		//throws exception in main
		Stream<String> lines = Files.lines(Paths.get("files/wordFile.txt"));
		lines.sorted()
			.filter(l -> l.length() > 6)
			.forEach(x -> System.out.println(x + ", "));
		lines.close(); // close stream
		
		
		System.out.println();
		
		// now, streaming files. 
		//throws exception in main
		//prints: Samantha, 
		//Health Insurance, 
		List<String> words = Files.lines(Paths.get("files/wordFile.txt"))
			.filter(x -> x.contains("th"))
			.collect(Collectors.toList());
		words.forEach(x -> System.out.println(x + ", "));
		
		System.out.println();
		
		// Another example
		// prints 3 good rows
		Stream<String> rows = Files.lines(Paths.get("files/stockDataCsv.txt")); // file has comma separated values 
		// stores in stream of strings.
		
		int rowCount = (int) rows // casting
				.map(x -> x.split(",")) // split eith comme . intermediate operation
				.filter(x -> x.length > 3) // filter lines that have more than 3 elements.  intermediate operation
				.count(); // terminal op
		System.out.println(rowCount + " good rows");
		rows.close(); // close stream
		
		System.out.println();

		
		// last example
		Stream<String> rows2 = Files.lines(Paths.get("files/stockDataCsv.txt")); // file has comma separated values 
		rows2.map(x -> x.split(",")) // split with comma . intermediate operation. from stream to array!!
			.filter(x -> x.length > 3) //interedted in the greater than t3
			.filter(x -> Integer.parseInt(x[1].trim()) > 15) //parse  text as numbers/integers . updated stream of data
			.forEach(x -> System.out.println(x[0].trim() + " " + x[2].trim()+ " " + x[3].trim())); //foreach over remaining stream lelements. 
		//print values of diff lines
		rows2.close();



	}//main

}//class
