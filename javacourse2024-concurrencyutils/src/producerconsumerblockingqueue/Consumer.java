package producerconsumerblockingqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	
	BlockingQueue<Integer> questionQueue;
	
	public Consumer(BlockingQueue<Integer> questionQueue) {
		this.questionQueue = questionQueue;
	}
	
	@Override
	public void run() {
		while(true) {
		
			try {
				Thread.sleep(1000);
				System.out.println("answered question: " + questionQueue.take()); //will retrieve and remove from queue
				// only use put and take!
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
