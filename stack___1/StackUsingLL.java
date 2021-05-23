package stack___1;

import linkedList_____1.Node;

public class StackUsingLL<T> {

	private Node<T> head;
	private int size;

	public StackUsingLL(){
		head=null;
		size=0;

	}

	public int size() {
		return size;
	}

	public boolean isempty() {
		if(size==0) {
			return true;
		}
		return false;
	}

	public void push(T elem) {
		Node<T> toadd=new Node<>(elem);
		//		if(head==null) {
		//			head=toadd;
		////			return;
		//		}else {
		toadd.next=head;
		head=toadd;
		//		}
		size++;

	}

	public T top() throws StackEmptyException {
		if(head==null) {
//			StackEmptyException e=new StackEmptyException();
//			throw e;
			// we can do the above thing or
			
			throw new StackEmptyException();
		}
		return head.data;
	}

	public T pop() throws StackEmptyException {
		if(head==null) {
			
			throw new StackEmptyException();
		}
		T ans=head.data;
		head=head.next;
		size--;
		return ans;
	}

}
