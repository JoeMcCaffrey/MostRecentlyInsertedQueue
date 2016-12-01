import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

// Creating methods static so 2 threads cannot use the same method at the same time

public class ConcurrentMostRecentlyInsertedQueue<T> extends AbstractQueue<T> {

	private int maxSize;
	private LinkedList<T> concurrentQueue; 
	
	public ConcurrentMostRecentlyInsertedQueue(int size){
		
		if(size <= 0){
			throw new NoSuchElementException("Queue has invalid size");
		}
		maxSize = size;
		concurrentQueue = new LinkedList<T>();
	}
	
	public synchronized boolean offer( T value) {

		// not allowing null inside of queue
		if(value == null) return false;
		
		// If we have room in the queue insert value
		if(concurrentQueue.size() < maxSize){
			//add the new element to the back of the queue
			return concurrentQueue.offer(value);
		}
		// dequeue so we can add the new element
		concurrentQueue.poll();
		return concurrentQueue.offer(value);							
	}

	public synchronized T peek() {
		//look at the first element in the queue, null if empty
		return concurrentQueue.peekFirst();
	}

	public synchronized T poll() {
		// returns the value inside of the node or null if queue is empty
		return concurrentQueue.pollFirst();
	}

	public synchronized Iterator<T> iterator() {
		// use the built in iterator 
		return concurrentQueue.iterator();
	}

	public synchronized int size() {		
		// return the size of the queue
		return concurrentQueue.size();
	}
	
	
	
	

}
