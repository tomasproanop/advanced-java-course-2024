package threadsynchronization;

//what happens when data is shared
//thread synchronization
public class Sequence {
	
	private int value = 0;
	
	public int getNext() {
		
		//value++; // code is not thread-safe!! 3 steps: value = value + 1;
		//return value;
		// variable is shared by multiple threads!!
		
		//safe way:
		
		//as soon as it enters the sync block, it won't let other thread take control until
		// it goes out of the block
		synchronized (this) {
			value = value + 1;
			return value;
		}
		
//		now, this is the output!! no duplicates!!
//		Thread-1 got value 102
//		Thread-0 got value 101
//		Thread-0 got value 104
//		Thread-1 got value 103
//		Thread-0 got value 105
//		Thread-1 got value 106
//		Thread-0 got value 107
//		Thread-1 got value 108
//		Thread-1 got value 110
//		Thread-0 got value 109
//		Thread-1 got value 111
//		Thread-0 got value 112
		
		// alternative: synchronized in method signature:
		//	public synchronized int getNext() {
		
	}
	
}
