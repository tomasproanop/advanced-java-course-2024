package threadsynchronization;

public class Application {

	public static void main(String[] args) {

		Sequence sequence = new Sequence();

		for (int i = 0; i < 100; i++) {

			System.out.println(sequence.getNext());
		}

		Worker worker1 = new Worker(sequence);
		worker1.start();
		
		Worker worker2 = new Worker(sequence);
		worker2.start();
		
		//prints:
//		Thread-1 got value 102
//		Thread-0 got value 101
//		Thread-1 got value 104
//		Thread-0 got value 103
//		Thread-0 got value 105
//		Thread-1 got value 105
//		Thread-0 got value 106
//		Thread-1 got value 107
//		Thread-0 got value 108
//		Thread-1 got value 109
		
		// the processor can only give control to one thread at a time. 
		//single thread program: just program in main thread. 
		//2 threads: processot needs to give control to both threads, but only
		// one thread at a time. 
		
		
		// that is called scheduling!!!
		
		

		
	}
}

//needs to override run method
class Worker extends Thread {
	
	Sequence sequence = null;

	public Worker(Sequence sequence) {
		this.sequence = sequence;
	}
	
	
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {

			System.out.println(Thread.currentThread().getName() + " got value " + sequence.getNext());
			
			try {
				// half a second
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}