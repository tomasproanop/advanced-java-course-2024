package producerconsumerblockingqueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	
	int questionNo;
	
	BlockingQueue<Integer> questionQueue;
	
	public Producer(BlockingQueue<Integer> questionQueue) {
		this.questionQueue = questionQueue;
	}
	
	@Override
	public void run() {
		
		while (true) {
		
			//questionNo++;//remember this is 3 steps!! so it may put to sleep before ending
			// better inside the try
			
			try {
				//questionQueue.put(questionNo++); // not thread-safe
				//questionQueue.put(getNextQuestion());  // not thread-safe
				
				synchronized(this) {
					int nextQuestion = questionNo++;
					//questionQueue.put(getNextQuestion()); /// 100% thread-safe
					// but problem: 2 synchroinized block!
					
					
					System.out.println("got new question: " + nextQuestion);
					questionQueue.put(nextQuestion);
				}
	
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	// in the end , this is not needed
//	private synchronized int getNextQuestion() {
//		int nextQuestion = questionNo++;
//		System.out.println("got new question: " + nextQuestion);
//		return nextQuestion;
//		
//	}
	

}
