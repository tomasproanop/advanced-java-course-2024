package producerconsumerwaitnotify;

import java.util.List;

public class Producer implements Runnable {

	List<Integer> questionList = null;
	//question1, question2, etc. 
	
	final int LIMIT = 5; //not more question until 5 are answered already
	
	private int questionNo;
	
	Object myObject = new Object(); // for sync
	
	
	
	public Producer(List<Integer> questionList) {
		this.questionList = questionList;
	}
	
	
	public void readQuestion(int questionNo) throws InterruptedException {
		
		synchronized(questionList) {
			
			while (questionList.size() == LIMIT){
				System.out.println("questions have piled up, wait for answers");
				//wait method
				
				//list is shared resources between consumer and producer! 
				//hence -> synchronized
				
				// wait belongs to object class
					questionList.wait();
			}
		}
			
			synchronized(questionList) {
				System.out.println("new question: " + questionNo);
				questionList.add(questionNo);
				Thread.sleep(100);
				//notifies, so those threads that sleep wake up. 
				questionList.notify();
			}

			// wait and notify can onl be called inside sync block!
		}
		

	@Override
	public void run() {
		
		while(true) {
			try {
				readQuestion(questionNo++);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
