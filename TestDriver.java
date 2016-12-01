import java.util.Queue;

public class TestDriver {
	
	// Class for Main and some tests
	

	public static void checkValue(Integer expect, Integer actual){
		
		if(expect == actual){
			System.out.println(expect+" equaled "+actual+ " .....Pass");
		}
		else{
			System.out.println(expect + " doesn't equal "+ actual+ " .....Fail");
		}	
	}
	
	public static void checkValue(Boolean expect, Boolean actual){
		
		if(expect == actual){
			System.out.println(expect+" equaled "+actual+ " .....Pass");
		}
		else{
			System.out.println(expect + " doesn't equal "+ actual+ " .....Fail");
		}
	}
	
	public static void RunQueue3() {
		Queue<Integer> queue = new MostRecentlyInsertedQueue<Integer>(3);
		
		//edge cases
		checkValue(true,queue.isEmpty());
		checkValue(false, queue.offer(null));
		checkValue(true,queue.isEmpty());
		
		
		checkValue(true, queue.offer(1));
		checkValue(1, queue.peek());
		checkValue(1, queue.size());
		
		checkValue(true,queue.offer(2));
		checkValue(true,queue.offer(3));
		checkValue(true,queue.offer(4));
		
		checkValue(false,queue.isEmpty());
		checkValue(3,queue.size());
		
		checkValue(2,queue.peek());
		checkValue(2,queue.poll());
		checkValue(2,queue.size());
		
		checkValue(3,queue.element());
		checkValue(3,queue.remove());
		checkValue(1,queue.size());
		checkValue(4, queue.peek());
		
		queue.clear();
		checkValue(0, queue.size());
		System.out.println(queue.peek());
		System.out.println(queue.poll());
		System.out.println(queue.toString());
		
		checkValue(true,queue.offer(5));
		checkValue(true,queue.offer(6));
		checkValue(true,queue.offer(7));
		System.out.println(queue.toString());
		checkValue(true, queue.contains(5));
		
		queue.clear();
		
		System.out.println(queue.toString());
		checkValue(true, queue.offer(-1));
		System.out.println(queue.toString());
	
	}
	
	public static void RunQueue1(){
		
		Queue<Integer> queue = new MostRecentlyInsertedQueue<Integer>(1);
		checkValue(true,queue.offer(2));
		checkValue(2, queue.peek());
		System.out.println(queue.toString());
		checkValue(true,queue.offer(1));
		checkValue(1, queue.peek());
		System.out.println(queue.toString());
		
	}

	public static void main(String[] args){
		System.out.println("Run Queue3..........");
		RunQueue3();
		System.out.println("Run Queue1..........");
		RunQueue1();
	}
}
