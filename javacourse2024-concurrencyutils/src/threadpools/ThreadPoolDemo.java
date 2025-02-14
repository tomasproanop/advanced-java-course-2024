package threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {

	public static void main(String[] args) {
		//2 threads to get things done
		// they will be recycled
		ExecutorService executor = Executors.newFixedThreadPool(2);	
		
		//these are tasks submitted to executor service. 
		
		Runnable processor = new MessageProcessor(2);
		executor.execute(processor);
		
		Runnable processor2 = new MessageProcessor(3);
		executor.execute(processor2);

		Runnable processor3 = new MessageProcessor(4);
		executor.execute(processor3);
		
		Runnable processor4 = new MessageProcessor(5);
		executor.execute(processor4);
		//prints:
//		pool-1-thread-2RECEIVED 	message = 3
//		pool-1-thread-1RECEIVED 	message = 2
//		pool-1-thread-1DONE processing message = 2
//		¡pool-1-thread-2DONE processing message = 3
//		pool-1-thread-1RECEIVED 	message = 4
//		pool-1-thread-1DONE processing message = 4
		
		//rejects any new tasks from being submitted. 
		// gracefully shuts down the service
		executor.shutdown();
		//executor.shutdownNow(); // terminate the executor service immediately
		//causes InterruptedException in this case. 
		// Ahmad does not like it.
		
		
		//another method is await termination
		try {
			//TimeUnit is a container of variables to use...
			//waits 10 seconds before moving to the next line. 
			executor.awaitTermination(10, TimeUnit.SECONDS);
			// if 10 secs are set, "some string" is also printed in the end
			//if 2 secs are set, it is printed right after the first tas
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//while(!executor.isTerminated()) { // while not terminated
			//wait until terminated
			// "some string" is now printed in the end!
			
		//}
		
		System.out.println("some string");
		
		//order: tasks submitted, print string, waits 2 secs and does tasks

	}
}
