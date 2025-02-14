package lesson2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Application {

	public static void main(String[] args) {

		ArrayList<String> animals = new ArrayList<String>();
		animals.add("lion");
		animals.add("cat");
		animals.add("dog");
		animals.add("bird");
		
		for(int i = 0; i < animals.size(); i++) {
			System.out.println(animals.get(i));
		}
		
		for(String value : animals) {
			System.out.println(value);
		}
		
		////////
		
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		
		// just the same!
		List<Vehicle> vehicles2 = new LinkedList<Vehicle>();

		
		vehicles.add(new Vehicle("Honda", "Accord", 12000, false));
		
		Vehicle vehicle2 = new Vehicle("Toyota", "Camry", 12000, false);

		vehicles.add(vehicle2);
		
		vehicles.add(new Vehicle("Jeep", "Wrangler", 25000, true));
		
		for (Vehicle vehicle : vehicles) {
			System.out.println(vehicle.model);
		}
		
		System.out.println("################################");
		for (Vehicle vehicle : vehicles) {
			System.out.println(vehicle.toString());
		}
		
		
		printElements(vehicles);
		printElements(animals);
		

		

	}
	
	//list is super-type of ArrayList and LinkedList
	public static void printElements(List someList) {
		for(int i=0; i<someList.size(); i++) {
			System.out.println(someList.get(i));
		}
	}

}
