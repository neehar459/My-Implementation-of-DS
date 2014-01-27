public class DLL{

	private int size;
	private DLLNode head;
	
	public void setSize(int size){
		this.size = size;
	}
	
	public int getSize(){
		return this.size;
	}
	
	public void setHead(DLLNode sNode){
		this.head = sNode;
	}
	
	public DLLNode getHead(){
		return this.head;
	}
	
	public DLL(){
	}
	
	public DLL(int size){
		this.size = size;
	}
	
	// add element to the last of the list
	public boolean add(int value){
		if(null!=this.addLast(value)){
			return true;
		}else{
			return false;
		}
	}
	
	// add element to the left of the list
	public DLLNode addFirst(int value){
		DLLNode sNode = new DLLNode(value);
		if(size ==0){
			this.setHead(sNode);
			this.getHead().setNext(null);
			size++;
		}else{
			DLLNode tempHead = this.getHead();
			sNode.setNext(tempHead);
			this.setHead(sNode);
			size++;
		}
		return sNode;
	}
	
	// add Element at a corresponding position to the list
	public void add(int index, int value){
		int loopCounter=1;
		DLLNode toInsert = new DLLNode(value);
		if(index<0){
			throw new IllegalArgumentException("List position cannot be negative.");
		}else if(index==1){
			this.addFirst(value);
			}
		else if(index == this.size){
			this.addLast(value);
		}else{
		DLLNode toIterate = this.getHead();
		do{
		DLLNode beforeNext = toIterate.getNext(); 
		if((loopCounter+1)==index){
		toIterate.setNext(toInsert);
		toIterate.getNext().setNext(beforeNext);
		size++;
		break;
		}
		toIterate = toIterate.getNext();
		loopCounter++;
		}while(true);
		}
	}
	
	// add Element to the last of the list
	public DLLNode addLast(int value){
		DLLNode sNode = new DLLNode(value);
		if(size ==0){
			this.setHead(sNode);
			this.getHead().setNext(null);
			size++;
		}else{
			DLLNode toIterate = this.getHead();
			do{
				if(null==toIterate.getNext()){
				toIterate.setNext(sNode);
				toIterate.getNext().setNext(null); // newly added code
				size++;
				break;
				}
				toIterate = toIterate.getNext();
			}while(true);
		}
		return sNode;
	}
	
	// Returns the first element of the list
	public int getFirst(){
		int toReturn = -1;
		if(this.size==0){
			throw new IllegalArgumentException("List is Empty. Cannot retrieve first element.");
		}else{
		toReturn = this.getHead().getValue();
		}
		return toReturn;
	}
	
	// Returns last element of the list
	public int getLast(){
		int toReturn = -1;
		int loopCounter=1;
		DLLNode toIterate = this.getHead();
		if(this.size==0){
			throw new IllegalArgumentException("List is Empty. Cannot retrieve first element.");
		}else{
		do{
		toReturn = toIterate.getValue();
		loopCounter++;
		toIterate = toIterate.getNext();
		}while(loopCounter<=size);
		}
		return toReturn;
	}
	
	// Assuming that index of list starts at 1.
	public int get(int index){
		int toReturn =-1;
		int iteratorIndex =1;
		if(index <0){
			throw new IllegalArgumentException(" Index cannot  be less than 0.");
		}else{
			DLLNode iterNode = this.getHead();
			do{
			if(iteratorIndex == index){
				toReturn = iterNode.getValue();
			}
			iterNode = iterNode.getNext();
			iteratorIndex++;
			}while(iteratorIndex <=index);
		}
		return toReturn;
	}
	
	// to check if an element is present in the list or not
	public boolean contains(int value){
		boolean status = false;
		int loopCounter=1;
		DLLNode toIterate = this.getHead();
		do{
		if(toIterate.getValue()==value){
		status = true;
		}
		loopCounter++;
		toIterate = toIterate.getNext();
		}while(loopCounter<=this.size);
		return status;
	}
	
	// this function returns the index of the element to search
	public int indexOf(int value){
		int index=-1;
		int loopCounter=1;
		DLLNode toIterate = this.getHead();
		do{
		if(toIterate.getValue()==value){
		index = loopCounter;
		break;
		}
		loopCounter++;
		toIterate = toIterate.getNext();
		}while(loopCounter<=this.size);
		return index;
	}
	
	// this returns the last index of element to search in the list
	public int lastIndexOf(int value){
	int index =-1;
	int loopCounter=1;
		DLLNode toIterate = this.getHead();
		do{
		if(toIterate.getValue()==value){
		index = loopCounter;
		}
		loopCounter++;
		toIterate = toIterate.getNext();
		}while(loopCounter<=this.size);
	return (index);
	}
	
	// this clears the list
	public void clear(){
		int initialSize = this.size;
	if(this.size==0){
		throw new IllegalArgumentException("List is already empty.");
	}else{
		for(int i=1; i <=initialSize; i++){
			this.deleteFirst();
		}
	}
	}
	
	// to display the LinkedList
	public void displayDLL(){
		System.out.println("----------------- Displaying single Linked List -----------------");
		if(size ==0){
		System.out.println("List is empty. No element to display");	
		}else{
			DLLNode iteratingPointer = this.getHead();
			do{
				System.out.print(iteratingPointer.getValue() +" ---> ");
				iteratingPointer = iteratingPointer.getNext();
			}while(null!=iteratingPointer);
			System.out.println(" ");
		}
	}
	
	// to delete head node of the linked list
	public DLLNode deleteFirst(){
		DLLNode toReturn = null;
		if(size==0){
			throw new IllegalArgumentException("List is already Empty. Cannot delete more");
		}else{
		toReturn = this.getHead();
		this.setHead(toReturn.getNext());
		size--;
		}
		return toReturn;
	}
	
	// to delete Last Node of the linked list
	public DLLNode deleteLast(){
		DLLNode toReturn = null;
		if(size==0){
			throw new IllegalArgumentException("List is already Empty. Cannot delete more");
		}else{
			DLLNode toIterate = this.getHead();
			do{
			if(null==toIterate.getNext().getNext()){
			toIterate.setNext(null);
			size--;
			}
			toIterate = toIterate.getNext();
			}while(null!=toIterate);
		}
		return toReturn;
	}
	
	// to delete Node at given index
	public DLLNode delete(int index){
		DLLNode deletedNode = null;
		int loopCounter=1;
		if(this.size==0){
			throw new IllegalArgumentException("List is already empty. Cannot delete more");
		}else if(index<=0){
			throw new IllegalArgumentException("Index cannot be negative");
		}else if(index == 1){
			this.deleteFirst();
		}else if(index == size){
			this.deleteLast();
		}
		else{
		DLLNode toIterate = this.getHead();
		do{
		if((loopCounter+1)==index){
		toIterate.setNext(toIterate.getNext().getNext());
		size--;
		break;
		}
		loopCounter++;
		toIterate = toIterate.getNext();
		}while(loopCounter<=this.size);
		}
		return deletedNode;
	}
	
	public static void main(String[] args){
		DLL DLL = new DLL();
		DLL.displayDLL();
		DLL.addFirst(1);
		DLL.addFirst(2);
		DLL.addFirst(3);
		DLL.addFirst(4);
		DLL.addLast(5);
		DLL.addLast(6);
		DLL.addLast(7);
		DLL.addLast(8);
		System.out.println("List Size after adding all elements: "+DLL.getSize());
		DLL.displayDLL();
		DLL.deleteFirst();
		System.out.println("List Size after delete first : "+DLL.getSize());
		DLL.displayDLL();
		DLL.deleteLast();
		System.out.println("List Size after delete last : "+DLL.getSize());
		DLL.displayDLL();
		//DLL.delete(-1);
		System.out.println("List Size after deleting element at index -1: "+DLL.getSize());
		DLL.displayDLL();
		DLL.delete(5);
		System.out.println("List Size after deleting element at index 5: "+DLL.getSize());
		DLL.displayDLL();
		DLL.add(2,23);
		System.out.println("List Size after add(2,23): "+DLL.getSize());
		DLL.displayDLL();
		DLL.add(4,44);
		DLL.add(5,2);
		System.out.println("List Size after add(5,2): "+DLL.getSize());
		DLL.displayDLL();
		System.out.println(DLL.contains(2));
		System.out.println("First Element : "+DLL.getFirst());
		System.out.println("Last Element : "+DLL.getLast());
		System.out.println("Index of element : "+DLL.indexOf(2));
		System.out.println("Index of element : "+DLL.lastIndexOf(2));
		System.out.println("List Size before clear : "+DLL.getSize());
		DLL.clear();
		//DLL.deleteFirst();
		System.out.println("List Size : "+DLL.getSize());
		DLL.displayDLL();
	}
}

class DLLNode{
	private int value;
	private DLLNode next;
	
	public DLLNode(int value){
		this.value = value;
	}
	
	public void setValue(int value){
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}
	
	public void setNext(DLLNode sNode){
		this.next = sNode;
	}
	
	public DLLNode getNext(){
		return this.next;
	}
}
