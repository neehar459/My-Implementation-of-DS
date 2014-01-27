public class MyStack{
	
	int capacity = 10;
	int[] iArray = new int[capacity];
	int topOfStack = -1;
	
	public static void main(String[] args){
		MyStack mStack = new MyStack();
		mStack.push(1);
		mStack.push(2);
		mStack.push(3);
		mStack.push(4);
		mStack.push(5);
		mStack.displayStack();
		System.out.println("Is Stack Empty : "+mStack.isEmpty());
		System.out.println("Element popped : "+mStack.pop());
		System.out.println("Element at the top of stack : "+mStack.peek());
		mStack.displayStack();
		mStack.displayStackReverse();
	}
	
	// this method allows to push elements on to stack
	public int push(int element){
		if(topOfStack==-1){
			iArray[topOfStack+1] = element;
			topOfStack++;
			return element;
		}else{
			if(topOfStack == iArray.length-1){
				// Implicit array will be doubled in size and all the initial elements will be copied on to the new array.
				doubleArraySize();
				iArray[topOfStack+1] = element;
				topOfStack++;
				return element;
			}else{
				iArray[topOfStack+1] = element;
				topOfStack++;
				return element;
			}
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
	
	// This method removes the top element from stack and returns that element
	public int pop(){
		if(isEmpty()){
			return -1;
		}else{
			int toReturn = iArray[topOfStack];
			iArray[topOfStack]=-1;
			topOfStack--;
			return toReturn;
		}
	}
	
	// This method checks if the stack is empty or not.
	public boolean isEmpty(){
		if(topOfStack==-1){
			return true;
		}else{
			return false;
		}
	}
	
	// This method returns the top element of the stack with out removing
	public int peek(){
		if(isEmpty()){
			throw new IllegalArgumentException("Stack is already empty");
		}else{
			return iArray[topOfStack];
		}
	}
	
	// This method displays the stack
	public void displayStack(){
		if(topOfStack==-1){
			throw new IllegalArgumentException("Stack does not have elements");
		}else{
			for(int i=topOfStack; i>=0;i--){
				System.out.print("---> " + iArray[i]);
			}
			System.out.println(" ");
		}
	}
	
	// This method displays stack in reverse order
	public void displayStackReverse(){
		if(topOfStack==-1){
			throw new IllegalArgumentException("Stack does not have elements");
		}else{
			for(int i=0; i<=topOfStack; i++){
				System.out.print("---> "+iArray[i]);
			}
			System.out.println(" ");
		}
	}
}
