package client;

import inventory.InventoryManager;

public class Application {

	public static void main(String[] args) {

		InventoryManager manager = new InventoryManager();
		// main thread runs line by line
		//2 threads, both are accessing the Inventory Manager class...
		
		Thread inventoryTask = new Thread(new Runnable() {

			@Override
			public void run() {
				manager.populateSoldProducts();

			}
			
		});
		
		Thread displayTask = new Thread(new Runnable() {

			@Override
			public void run() {
				manager.displaySoldProducts();

			}
			
		});
		
//		inventoryTask.start();
//		try {
//			//main thread
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		displayTask.start(); // list may be empty when it starts

	
	
	//problem:
//	Exception in thread "Thread-1" java.util.ConcurrentModificationException
//	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1096)
//	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1050)
//	at inventory.InventoryManager.displaySoldProducts(InventoryManager.java:28)
//	at client.Application$2.run(Application.java:27)
//	at java.base/java.lang.Thread.run(Thread.java:1570)
//Added: id=164, name=test_product164
	
	// collections are not thread safe out of the box. must use synchronized
	// or m(primitive) make it sleep for a longer time...
	// better: join!!
		
		
//		inventoryTask.start();
//		try {
//			//hold until it is completed. 
//			// this way it is sequential, not multi-threaded
//			inventoryTask.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		displayTask.start();
		
		//lastls, with copyonwritearraylist, it is interleaving!
		
		inventoryTask.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		displayTask.start();
	}
	
	//e.g.
//	Added: id=265, name=test_product265
//	printing the sold: id=102, name=test_product102
//	Added: id=266, name=test_product266
//	printing the sold: id=103, name=test_product103
	
	//executor y thread pools son mejor. esto es muy low level!

}
