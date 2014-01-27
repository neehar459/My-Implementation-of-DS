public class MyQueue{
	int capacity = 10;
	int[] iArray = new int[capacity];
	int front=-1;
	int rear = 0;
	public static void main(String[] args){
		MyQueue mQ = new MyQueue();
		mQ.enqueue(1);
		mQ.enqueue(2);
		mQ.enqueue(3);
		mQ.displayQueue();
		System.out.println("DeQueued Element : "+mQ.deQueue());
		mQ.enqueue(4);
		mQ.enqueue(5);
		mQ.displayQueue();
		System.out.println("First Element : "+mQ.peek());
	}
	
	// This method adds an element from the back of the queue
	public int enqueue(int element){
		if(front == -1){
			iArray[rear]= element;
			front++;
			//rear++;
			return element;
		}else{
			if(rear == iArray.length-1){
				doubleArraySize();
				iArray[rear+1] = element;
				rear++;
				return element;
			}
			else{
				iArray[rear+1] = element;
				rear++;
				return element;
			}
		}
	}
	
	// This method adds an element from the back of the queue
	public int deQueue(){
		if(front == -1){
			throw new IllegalArgumentException("Queue is Empty");
		}else{
			int toReturn = iArray[front];
			front++;
			return toReturn;
			
		}
	}
	
	// This method returns the element at the first of the queue
	public int peek(){
		if(isEmpty()){
			throw new IllegalArgumentException("Queue does not have elements");
		}else{
			return iArray[front];
		}
	}
	
	// This method doubles the size of the Array and copies old elements of array in to a new array which will be returned
	public void doubleArraySize(){
		int[] newArray = new int[2*iArray.length];
		for(int i=0;i<iArray.length;i++){
			newArray[i] = iArray[i];
		}
		iArray = newArray;
	}
	
	// This method checks if the queue is empty or not
	public boolean isEmpty(){
		if(front==-1){
			return true;
		}else{
			return false;
		}
	}
	
	// This method displays the stack
	public void displayQueue(){
		if(front==-1){
			throw new IllegalArgumentException("Queue does not have elements");
		}else{
			for(int i=front; i<=rear; i++){
				System.out.print("---> " + iArray[i]);
			}
			System.out.println(" ");
		}
	}
}
