package builtInFuncInterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class App {

	public static void main(String[] args) {
		
		List<Car> cars = Arrays.asList(
				new Car("Honda", "Accord", "Red", 22300),
				new Car("Honda", "Civic", "Blue", 17700),
				new Car("Toyota", "Land Cruiser", "White", 48500),
				new Car("Toyota", "Corolla", "Black", 16200),
				new Car("Toyota", "Camry", "Blue", 24000),
				new Car("Nissan", "Sentra", "White", 17300),
				new Car("Mitsubishi", "Lancer", "White", 20000),
				new Car("Jeep", "Wrangler", "Red", 24500)
				);


		printCarsPriceRange(cars, 18000, 22000);
		printCarByColor(cars, "Red");


		System.out.println("Printing cars between price 18000 and 22000");
		printCars(cars, new CarCondition() {

			@Override
			public boolean test(Car c) {
				return c.getPrice() >= 18000 && c.getPrice() <= 22000;
			}
		});
	
		System.out.println("Printing cars that are blue");
		printCars(cars, new CarCondition() {

			@Override
			public boolean test(Car c) {
				return c.getColor().equals("Blue");
			}

		});

		System.out.println("Printing cars between price 18000 and 22000");
		printCars(cars, (c) -> c.getPrice() >= 18000 && c.getPrice() <= 22000);

		System.out.println("Print blue cars");
		printCars(cars, (c) -> c.getColor().equals("Blue"));

	}


	public static void printCars(List<Car> cars, CarCondition condition) {
		for(Car c: cars) {
			if(condition.test(c)) {
				c.printCar();
			}
		}
	}


	public static void printCarsPriceRange(List<Car> cars, int low, int high) {
		for(Car c: cars) {
			if(low <= c.getPrice() && c.getPrice() <= high) {
				c.printCar();
			}
		}
	}


	public static void printCarByColor(List<Car> cars, String color) {
		for(Car c: cars) {
			if(low <= c.getColor().equals(color)) {
				c.printCar();
			}
		}
	}

	

		Function<Car, String> priceAndColor = (c) -> " price = " + c.getPrice() + " color = "+ c.getColor();			
		String stringCar = priceAndColor.apply(cars.get(0));
		System.out.println(stringCar);



	public static void printCars(List<Car> cars, Predicate<Car> predicate) {
		for(Car c: cars) {
			if(predicate.test(c)) {
				c.printCar();
			}
		}
	}

}


@FunctionalInterface
interface CarCondition {
	public boolean test(Car c);
}
