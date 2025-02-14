package lesson8genwildcards;

public class Accountant extends Employee {
	
	//overrides from parent class
	@Override
	public void work() {
		System.out.println("Accountant (children) doing some work");
	}

}
