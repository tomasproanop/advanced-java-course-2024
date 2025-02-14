package inventory;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

//thread safety with collections
public class InventoryManager {

//	List<Product> soldProductsList = new ArrayList<Product>();	
//	List<Product> purchasedProductsList = new ArrayList<Product>();	
	
	List<Product> soldProductsList = new CopyOnWriteArrayList<Product>();	
	List<Product> purchasedProductsList = new CopyOnWriteArrayList<Product>();	
	
	Vector vector = new Vector();

	public void populateSoldProducts() {
		for (int i=0; i < 500; i++) {
			Product prod = new Product(i, "test_product" + i);
			soldProductsList.add(prod);
			System.out.println("Added: " + prod);
			
			//this sleep is innecessary, just to show. 
			try {
				Thread.sleep(10);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		
		public void displaySoldProducts() {
			for(Product product : soldProductsList) {
				System.out.println("printing the sold: " + product);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//min 6:09

