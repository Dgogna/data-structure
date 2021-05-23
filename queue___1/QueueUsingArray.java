package queue___1;

public class QueueUsingArray {

	private int data[];
	private int front;
	private int rear;
	private int size;

	public QueueUsingArray(){
		data=new int[5];
		front=-1;
		rear=-1;
		size=0;
	}

	public int size() {
		return size;
	}

	public boolean isempty() {
		return size==0;
	}

	public void enque(int elem) throws QueueFullException {
		if(size==data.length) {
			//throw new QueueFullException();
			DoubleCapacity();
		}
		//		if(front==-1) {
		//			front++;
		//			data[front]=elem;
		//			rear=front;
		//		}else {
		if(front==-1) {
			front++;
		}
//		rear++;
//		if(rear==data.length) {
//			rear=0;
//		}
		// just the shorter war to write the above statement;
		rear=(rear+1)%data.length;
		data[rear]=elem;
		//	}
		size++;
	}

	private void DoubleCapacity() {
		int temp[]=data;
		data=new int[temp.length*2];
		int index=0;
		for(int i=front;i<temp.length;i++) {
			data[index]=temp[i];
			index++;
		}
		
		for(int i=0;i<=rear;i++) {
			data[index++]=temp[i];
		}
		
		front=0;
		rear=temp.length-1;
	}

	public int front() throws QueueEmptyException {
		if(front==-1) {
			throw new QueueEmptyException();
		}
		return data[front];
	}

	public int deque() throws QueueEmptyException {
		if(front==-1) {
			throw new QueueEmptyException();
		}
		int store=data[front];
//		front++;
//		if(front==data.length) {
//			front=0;
//		}
		// just the shorter war to write the above statement;
		front=(front+1)%data.length;
		size--;
		if(size==0) {
			front=-1;
			rear=-1;
		}
		return store;
	}

}
