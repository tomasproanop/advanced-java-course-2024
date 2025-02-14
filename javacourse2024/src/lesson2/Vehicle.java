package lesson2;

public class Vehicle {
	
	String make;
	String model;
	int price;
	boolean fourWDrive;
	
	public Vehicle(String make, String model, int price, boolean fourWDrive) {
		super();
		this.make = make;
		this.model = model;
		this.price = price;
		this.fourWDrive = fourWDrive;
	}

	String getMake() {
		return make;
	}

	//created via "Source" menu
	@Override
	public String toString() {
		return "Vehicle [make=" + make + ", model=" + model + ", price=" + price + ", fourWDrive=" + fourWDrive + "]";
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isFourWDrive() {
		return fourWDrive;
	}

	public void setFourWDrive(boolean fourWDrive) {
		this.fourWDrive = fourWDrive;
	}

	public void setMake(String make) {
		this.make = make;
	}
}
