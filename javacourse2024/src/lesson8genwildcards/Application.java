package lesson8genwildcards;

import java.util.ArrayList;
import java.util.List;

public class Application {

	public static void main(String[] args) {
		
		// grandparent of every object is object class
		Object myObject = new Object();
		
		String myVar = "hi";
		
		//polymorphism
		myObject = myVar;
		
		////////////
		
		Employee employee = new Employee();
		Accountant accountant = new Accountant();
		// como acc es empl, se puede hacer zuweisen 
		
		employee = accountant;
		
		//type ArrayList<Employee>
		ArrayList<Employee> employees = new ArrayList<Employee>();
		//add employeet to list
		employees.add(new Employee());
		
		//type ArrayList<Accountant> 
		ArrayList<Accountant> accountants = new ArrayList<Accountant>();
		accountants.add(new Accountant());
		
		// that means limited flexibility
		//error
		//employees = accountants;
		
		// ? means anon type
		ArrayList<?> employees2 = new ArrayList<>();
		ArrayList<Accountant> accountants2 = new ArrayList<Accountant>();
		
		//just fine
		employees2 = accountants2;
		
		//    ? means  whatever children from employee class, are allowed in this list
		//upper bound!! nothing greater than Employee. E.g. Object -> no!
		// only employee or its children can be passed
		// all derivative of employee type is allowed. 
		//allows for some flexibility
		ArrayList<? extends Employee> employees3 = new ArrayList<>();
		ArrayList<Accountant> accountants3 = new ArrayList<Accountant>();
		
		// is allowed
		employees3 = accountants3;
		
		
		//lower bound
		//only employees and parent (object) can go into the list
		//prevents subclasses to go into the list. 
		ArrayList<? super Employee> employees4 = new ArrayList<>();
		ArrayList<Accountant> accountants4 = new ArrayList<Accountant>();
		
		// not allowed!!!
		//employees4 = accountants4;
		
		//pass employees list as parameter
		makeEmployeesWork(employees);
		
		//error! only type employee
		//makeEmployeesWork(accountants);
		
		//only works if method signature is:
		//here any child can be passed! no matter which child!!!
		//	public static void makeEmployeesWork(List<? extends Employee> employees) {
		
		makeEmployeesWorkGeneric(accountants);

		
	}
	
	public static void makeEmployeesWork(List<Employee> employees) {
		
		for(Employee employee : employees) {
			employee.work();
		}
		
	}
	
	public static void makeEmployeesWorkGeneric(List<? extends Employee> employees) {
		
		//we need to cast!! emp to acc
		//downside: no type-safety! compiler does not know if it is casting to the correct type. 
		// even a non-existing type could be entered here and it would accept it
		// See warning!!
		for(Employee employee : (ArrayList<Accountant>)employees) {
			employee.work();
		}
		
	}

}
