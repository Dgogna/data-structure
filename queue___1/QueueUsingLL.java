package queue___1;
import linkedList_____1.Node;

public class QueueUsingLL<T> {

	Node<T> front;
	Node<T> rear;
	int size;
	
	public QueueUsingLL() {
		front=null;
		rear=null;
		size=0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isempty() {
		return size==0;
	}
	
	public void enque(T elem) {
		Node<T> toadd=new Node<>(elem);
		if(front==null) {
			front=toadd;
			rear=front;
		}else {
			rear.next=toadd;
			rear=rear.next;
		}
		size++;
	}
	
	public T front() throws QueueEmptyException {
		if(front==null) {
			throw new QueueEmptyException();
		}
		return front.data;
	}
	
	public T deque() throws QueueEmptyException {
		if(front==null) {
			throw new QueueEmptyException();
		}
		T store=front.data;
		front=front.next;
		if(front==null) {
			rear=null;
		}
		size--;
		return store;
	}
	
}
