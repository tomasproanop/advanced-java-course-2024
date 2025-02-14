package client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fileprocessors.StockFileData;
import fileprocessors.StockFileReader;

public class StockFileApplication {
	
	// populate data structure dataResult. a su vez populates fileData.
	public static void main(String args[]) throws IOException{
		StockFileReader fr = new StockFileReader("table.csv");
		
		List<HashMap<String, Double>> dataResult = populateStockFileData(fr.getHeaders(), fr.readFileData());
		StockFileData fileData = new StockFileData();
		fileData.addData(dataResult);
		fileData.printData();
		System.out.println("number of records: " + dataResult.size());
	}
	/**
	 * Complete the method body so that it returns the given structure needed to 
	 * populate the data field in the StockFileData class. 
	 * @param headers
	 * @param lines
	 * @return List
	 */
	public static List<HashMap<String, Double>> populateStockFileData(List<String> headers, List<String> lines){
		List<HashMap<String, Double>> dataResult = new ArrayList<>();
		
	
		// Insert your code here..
		
		for(String line : lines) {
			//each hashmap separated by a comma. 
			String [] values = line.split(",");
			
			//counter variable for index, for the headers
			int counter = 0;
			
			//here the hashmap is declared
			//do not need to rewrite wrapper classes inside the second <>, 
			//Java knows what is meant
			HashMap<String, Double> headerValueMap = new HashMap<>();
			
			//iterate over values array
			for(String value : values) {
				//convert string into double. for wrapper Double
				double dval = Double.parseDouble(value);
				
				//populate map with key is equal toe ach header (open, high, close...)
				
				//define hashmap outside
				
				//                   counter is index position
				headerValueMap.put(headers.get(counter), dval);
				counter++;
			}
			dataResult.add(headerValueMap);
		}		
		return dataResult;
	}
	
	// first record is the header. 
	// then there are 250 records in the file. 
	// as this line says
	//		System.out.println("number of records: " + dataResult.size());
	// total: 251
	
}
