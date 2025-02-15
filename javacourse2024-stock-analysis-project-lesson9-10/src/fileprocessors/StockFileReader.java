package fileprocessors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockFileReader {
	
	String filePath = null;
	
	public StockFileReader(String filePath){
		this.filePath = filePath;
	}
	
	public List<String> getHeaders() throws IOException{
		String line = readFirstLine(filePath);
		String [] header = line.split(",");
		List<String> values = new ArrayList<String>();
		values = Arrays.asList(header);
		return values;
	}
	
	static String readFirstLine(String path) throws IOException {
	    try (BufferedReader br =
	                   new BufferedReader(new FileReader(path))) {
	        return br.readLine();
	    }
	}
	/**
	 * Complete the body of this method.
	 * @return List
	 * @throws IOException
	 */
	public List<String> readFileData() throws IOException{
		
		// reads each line of the file
		List<String> lines = new ArrayList<String>();
		// Insert your code here..
		
		//try reading with resources. differs from java 7.
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			//read first line
			br.readLine();
			String line = null;
			//advance from 2nd line onwards
			while((line = br.readLine()) != null){
				lines.add(line);
			}
		}
	    return lines;
	}
	

}
