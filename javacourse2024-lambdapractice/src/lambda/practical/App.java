package lambda.practical;

public class App {
	
	public static void main(String[] args) {
	
	Human tom  = new Human();
	tom.walk();
	
	//somewhat like anonymous classes work
	walker(tom);
	
	Robot wale = new Robot();
	wale.walk();
	
	//somewhat like anonymous classes work
	walker(wale);
	
//	walker(new Walkable() {
//		
//		//java 7
//		@Override
//		public void walk() {
//			System.out.println("custom object walking");
//		}
//		//after java 7 -> convert this to lamba expression
//		
//	});
	
	// should look like this:
	//meaning: do whatever is after the arrow
		walker( () -> System.out.println("custom object walking"));
		
		
		//optional curly braces or for multiple lines
//		walker( () -> { 
//		System.out.println("custom object walking"); 
//		System.out.println("custom object walking"); });
	
	
	                 //type of a lamba expression is a functional interface!
	// a functional interface is a class with one abstract method
		
	//ALambdaInterface aBLockOfCode = () ->{ works also!
	Walkable aBLockOfCode = () ->{

		System.out.println("custom object walking");
		System.out.println("the object tripped");
	};
	
	walker(aBLockOfCode);
	
	// how convert that into lamba expression?

	// type "func interface" 
	//	|		     var name
	//  v                |
	ALambdaInterface helloVar = () -> System.out.println("hi there"); 
	
	ALambdaInterfaceReturnInt sumVar = (int1, int2) -> int1 + int2; 
	
	System.out.println(sumVar.compute(5, 6)); //printing 11 :)
	
	
	
	ALambdaInterfaceReturnInt ReturnDivideVar = (int1, int2) -> {
		
		if (int1 == 0) {
			return 0;
		}
		return int1/int2;
		
	};
	
	ALambdaInterfaceReturnString reverseString =  (string1) -> {
	
		String result = "";
		for(int i = string1.length() - 1; i >= 0; i--) {
			result = result + string1.charAt(i);
		}
		
		return result;
		
	};
	
	System.out.println(reverseString.reverse("Bicho"));
	
	ALambdaInterfaceReturnInt2 factorialMethod = (int int1) -> {
	
		int result = 1;
		
		for(int i = 1; i <= int1; i++) {
			result = i*result;
		}
		return result;
	};
	
	System.out.println(factorialMethod.computeFactorial(5));
	
	
	GenericFunctional<String> methodToShow = (string1) -> {
		
		String result = "";
		for(int i = string1.length() - 1; i >= 0; i--) {
			result = result + string1.charAt(i);
		}
		
		return result;
	};
	
	System.out.println(methodToShow.work("Cielo"));
	
	}
	

	
	
	//specific for human
	public static void walker1(Human human) {
		human.walk();
	}
	
	//for human and robot
	public static void walker(Walkable walkableEntity) {
		walkableEntity.walk();
	}
	
	//practice exercise
	public void sayHello() {
		System.out.println("hi there");
	}


	public int sum(int arg1, int arg2) {
		return arg1 + arg2;
		
	}
	
	public int nonZeroDivide(int arg1, int arg2) {
		if (arg1 == 0) {
			return 0;
		}
		return arg1/arg2;
	}
	
	public String reverse(String string1) {
		
		String result = "";
		for(int i = string1.length() - 1; i >= 0; i--) {
			result = string1 + string1.charAt(i);
		}
		
		return result;
	}
	
	public int factorial(int num) {
		
		int result = 1;
		
		for(int i = 1; i <= num; i++) {
			result = i*result;
		}
		return result;
		
	}
	
	
	
	

}//class


