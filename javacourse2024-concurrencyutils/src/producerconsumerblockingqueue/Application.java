package producerconsumerblockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//motivation: do not use the primitive methods wait and notify
// while working with shared data structures

//if showing error, change vuild path!

public class Application {

	public static void main(String[] args) {

		
		BlockingQueue<Integer> questionQueue = new ArrayBlockingQueue<Integer>(5);
		Thread t1 = new Thread(new Producer(questionQueue));
		Thread t2 = new Thread(new Consumer(questionQueue));

		
		t1.start();
		t2.start();
	}

	
	//console output
//	got new question: 0
//	got new question: 1
//	got new question: 2
//	got new question: 3
//	got new question: 4
//	got new question: 5
//	got new question: 6
//	answered question: 0
//	answered question: 1
//	got new question: 7
//	answered question: 2
//	got new question: 8
//	answered question: 3
//	got new question: 9
//	answered question: 4
//	got new question: 10
//	answered question: 5
//	got new question: 11
//	answered question: 6
//	got new question: 12
//	answered question: 7
//	got new question: 13
//	answered question: 8
//	got new question: 14
}
