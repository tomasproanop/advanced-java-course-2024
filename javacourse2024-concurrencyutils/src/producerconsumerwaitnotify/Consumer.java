package producerconsumerwaitnotify;

import java.util.List;
/**
 * consumer answers the questions from the producer
 */
public class Consumer implements Runnable {

	//shared list!
	List<Integer> questionList = null;
	//question1, question2, etc. 
	
	Object myObject = new Object(); // for sync
	
	
	public Consumer(List<Integer> questionList) {
		this.questionList = questionList;
	}
	
	
	public void answerQuestion() throws InterruptedException {
		
		synchronized(questionList) {
			
			while (questionList.isEmpty()){
				System.out.println("no questions to answers. waiting for producer to get questions");
				//wait method
	
				// wait belongs to object class
					questionList.wait();
			}
		}
			
			synchronized(questionList) {
				Thread.sleep(5000); // simmulates that is takes 5 sec to answer the question
				//removed from front (oldest) of the list (zero index position)
				System.out.println("answered question: " + questionList.remove(0));

				questionList.notify();
			}

			// wait and notify can onl be called inside sync block!
		}
		

	// execution of the task!
	@Override
	public void run() {
		
		while(true) {
			try {
				answerQuestion();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
