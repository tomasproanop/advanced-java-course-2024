package producerconsumerwaitnotify;

import java.util.ArrayList;
import java.util.List;

//producer consumer pattern is used to separate tasks 
public class Application {

	public static void main(String[] args) {
		//think questions as integer to save time
		//container of things to be done!
		List<Integer> questionList = new ArrayList<Integer>();
		
		// same list of question (shared data structure) is
		// passed to both producer and consumer 
		Thread t1 = new Thread(new Producer(questionList));
		
		Thread t2 = new Thread(new Consumer(questionList));
		
		t1.start();
		t2.start();
		
		// here inter thread communication is happening! nice :)
		
		//wait and notify are still low level/ primitive approaches! do not use them too often!

		

		

	}

}
