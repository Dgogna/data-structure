package priorityQueue___1;
import java.util.*;

public class MaxPriorityQueue {
	private ArrayList<Integer> heap;

	public MaxPriorityQueue() {
		heap=new ArrayList<>();
	}
	
	public boolean isEmpty() {
		if(getSize()==0) {
			return true;
		}
		return false;
	}

	public int getSize() {
		return heap.size();
	}

	public int getMax() {
		return heap.get(0);
	}

	public void insert(int ele) {
		heap.add(ele);
		int childIndex=heap.size()-1;
		int parentIndex=(childIndex-1)/2;

		while(childIndex>0) {
			if(heap.get(parentIndex)<heap.get(childIndex)) {
				int temp=heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex,temp);

				childIndex=parentIndex;
				parentIndex=(childIndex-1)/2;
			}else {
				return;
			}
		}
	}

	public int removeMax() {
		int ans=heap.get(0);
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);

		int parent=0;
		int leftChild=2*parent+1;
		int rightChild=2*parent+2;

		while(leftChild<heap.size()) {
			int max=parent;
			if(heap.get(max)<heap.get(leftChild)) {
				max=leftChild;
			}
			if(rightChild<heap.size() && heap.get(max)<heap.get(rightChild)) {
				max=rightChild;
			}
			if(max==parent) {
				break;
			}
			int temp=heap.get(max);
			heap.set(max, heap.get(parent));
			heap.set(parent,temp);

			parent=max;
			leftChild=2*parent+1;
			rightChild=2*parent+2;
		}
		return ans;

	}

}











