package priorityQueue___1;
import java.util.*;
public class PriorityQueue<T> {

	private ArrayList<Element<T>> heap;

	public PriorityQueue(){
		heap=new ArrayList<>();
	}

	public void insert(T val, int priority) {
		Element<T> toadd=new Element<>(val,priority);
		heap.add(toadd);
		int childrenIndex=heap.size()-1;
		int parentIndex=(childrenIndex-1)/2;

		while(childrenIndex>0) {
			if(heap.get(parentIndex).priority>heap.get(childrenIndex).priority) {
				Element<T> temp=heap.get(childrenIndex);
				heap.set(childrenIndex,heap.get(parentIndex));
				heap.set(parentIndex, temp);

				childrenIndex=parentIndex;
				parentIndex=(childrenIndex-1)/2;
			}else {
				return;
			}
		}
	}

	public T getMin() throws PriorityQueueException {
		if(isEmpty()) {
			throw new PriorityQueueException();
		}
		return heap.get(0).value;
	}

	public T removeMin() throws PriorityQueueException{
		if(isEmpty()) {
			throw new PriorityQueueException();
		}
		Element<T> store=heap.get(0);
		Element<T> toRemove=heap.get(heap.size()-1);
		heap.set(0, toRemove);
		heap.remove(heap.size()-1);
		int parent=0;
		int children1=2*parent+1;
		int children2=2*parent+2;
		while(children1<heap.size() ) {
			int minIndex=parent;
			if(heap.get(minIndex).priority>heap.get(children1).priority) {
				minIndex=children1;
			}
			if(children2<heap.size() && heap.get(minIndex).priority>heap.get(children2).priority) {
				minIndex=children2;
			}
			if(minIndex==parent) {
				break;
			}
			Element<T> temp =heap.get(minIndex);
			heap.set(minIndex, heap.get(parent));
			heap.set(parent, temp);
			
			parent=minIndex;
			children1=2*parent+1;
			children2=2*parent+2;

		}
		return store.value;
	}

	public int size() {
		return heap.size();
	}

	public boolean isEmpty() {
		if(size()==0) {
			return true;
		}
		return false;
		
	}

}
