package learningthreading;

import java.io.IOException;

//a thread is alike a flow through your program!!!
public class Application {

	public static void main(String[] args) {
		
		//if new thread is wanted, it will execute the code .
		// hi gets executed first,before the taskRunner gets (completely) executed .
		// it gets time for a thread to fire up. 
		
		System.out.println("starting thread 1");
		Task taskRunner = new Task("thread 1");
		taskRunner.start();
		
		//Runnable
		Task2 taskRunner1 = new Task2("task1 runnable");
		Thread t1 = new Thread(taskRunner1);
		t1.start();
		
		
		// it is never illegal to start a thread more than once. 
		// a thread can not be restarted once it has completed execution. see below. 
		
		System.out.println("hi");
		
		//can be executed again, but  a new instance is needed!!!!
		
		System.out.println("starting thread 2");
		Task taskRunner2 = new Task("thread 2");
		taskRunner2.start();
		// a class is a blueprint. here the blueprint "Task" is being reused. 
		
		
		//runnable example
		
		//Runnable: now interleaving. without new thread, it does not interleave.
		//Task2 taskRunner3 = new Task2("task2 runnable");
		Thread t2 = new Thread(new Task2("task2 runnable")); //equivalent instance
		t2.start();
		
		
		//it is also possible to create an anonymous class:
		Thread t3 = new Thread(new Runnable() {
			public void run() {
				
				//no name in anonymous class
				//Thread.currentThread().setName(this.name);
				
				for(int i = 0; i < 10; i++) {
					System.out.println("number: " + i + " - " + Thread.currentThread().getName());
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		
		
		
		
	
		
	}
	
}

//multi-threaded
class Task extends Thread {
	
	String name;
	
	public Task (String name) {
		this.name = name;
		
	}
	public void run() {
		
		Thread.currentThread().setName(this.name);
		
		for(int i = 0; i < 10; i++) {
			System.out.println("number: " + i + " - " + Thread.currentThread().getName());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

// not multi-threaded
class Task2 implements Runnable {
	
	String name;
	
	public Task2 (String name) {
		this.name = name;
		
	}
	public void run() {
		
		Thread.currentThread().setName(this.name);
		
		for(int i = 0; i < 10; i++) {
			System.out.println("number: " + i + " - " + Thread.currentThread().getName());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

