import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

// By Joe McCaffrey

public class MostRecentlyInsertedQueue<T> extends AbstractQueue<T> {

	private int maxSize;
	private LinkedList<T> linkQueue;
	
	// constructor accepts the max size of the queue.
	public MostRecentlyInsertedQueue(int size){
		if(size <= 0){
			throw new NoSuchElementException("Queue has invalid size");
		}
		//make size global
		maxSize = size;
		//create a empty linkedlist
		linkQueue = new LinkedList<T>();
	}

	public boolean offer(T value) {
		// not allowing null inside of queue
		if(value == null) return false;
		
		// If we have room in the queue insert value
		if(linkQueue.size() < maxSize){
			//add the new element to the back of the queue
			return linkQueue.offer(value);
		}
		// dequeue so we can add the new element
		linkQueue.poll();
		return linkQueue.offer(value);
	}

	public T peek() {
		//look at the first element in the queue, null if empty
		return linkQueue.peekFirst();
	}

	public T poll() {
		// returns the value inside of the node or null if queue is empty
		return linkQueue.pollFirst();
	}

	public Iterator<T> iterator() {
		// use the built in iterator 
		return linkQueue.iterator();
	}

	public int size() {		
		// return the size of the queue
		return linkQueue.size();
	}
	
	
	

}
