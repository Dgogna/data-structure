package stack___1;

public class StackUsingArray {
	
	private int data[];
	private int topIndex;
	
	public StackUsingArray() {
		data=new int[10];
		topIndex=-1;
	}
	
	public int size() {
		return topIndex+1;
	}
	
	public boolean isempty() {
		if(topIndex==-1) {
			return true;
		}
		return false;
	}
	
	public void push(int elem){
		// when the stack is full
		if(topIndex==data.length-1) {
			// throw a stack full Exception
//			StackFullException e=new StackFullException();
//			throw e;
			DoubleCapacity();
		}
		topIndex++;
		data[topIndex]=elem;
	}
	
	private void DoubleCapacity() {
		int length=data.length*2;
		int prevarr[]=data;
		data=new int [length];
		for(int i=0;i<prevarr.length;i++) {
			data[i]=prevarr[i];
		}
	}
	
	public int top() throws StackEmptyException {
		if(topIndex==-1) {
			StackEmptyException e=new StackEmptyException();
			throw e;
		}
		return data[topIndex];
	}
	
	public int pop() throws StackEmptyException {
		if(topIndex==-1) {
			StackEmptyException e=new StackEmptyException();
			throw e;
		}
		int ans= data[topIndex];
		topIndex--;
		return ans;
	}

}
