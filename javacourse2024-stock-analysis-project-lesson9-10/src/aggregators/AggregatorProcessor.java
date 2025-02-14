package aggregators;

import java.io.IOException;
import java.util.List;

import fileprocessors.StockFileReader;
//any child of agg and aggregator can extend this class
public class AggregatorProcessor<T extends Aggregator> {
	
	T aggregator;
	String file;

	public AggregatorProcessor(T aggregator, String file) {
		
		super();
		this.aggregator =  aggregator;
		this.file = file;
	
	}

	public double runAggregator(int columnIDX) throws IOException {
		StockFileReader fileReader = new StockFileReader(file);
		List<String> lines = fileReader.readFileData();
		columnIDX--; // because index starts at 0
		
		//convert int to double
		for(String line : lines) {
			String [] numbers = line.split(","); //split on the comma and return number
			//each line is placed into array of numbers
			Double value = Double.parseDouble(numbers[columnIDX]);
			aggregator.add(value);
		}
		
		double number = aggregator.calculate();
		return number;
	}
	
	
}
