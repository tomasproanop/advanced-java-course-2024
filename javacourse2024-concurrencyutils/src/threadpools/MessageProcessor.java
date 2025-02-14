package threadpools;

public class MessageProcessor implements Runnable{
	
	private int message;
	
	public MessageProcessor(int message) {
		this.message = message;
	}

	@Override
	public void run() {
		
		System.out.println(Thread.currentThread().getName() + "RECEIVED 	message = " + message);
		respondToMessage(); // make thread sleep to simulate doing some work
		System.out.println(Thread.currentThread().getName() + "DONE processing message = " + message);
	}

	public void respondToMessage() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("unable to process message: " + message);
		}
	}
}
