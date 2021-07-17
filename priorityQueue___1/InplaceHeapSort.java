package priorityQueue___1;

public class InplaceHeapSort {
	
	public static void downHeapify(int index,int arr[],int ei) {
		
		int parentIndex=index;
		int leftChildIndex=(2*parentIndex)+1;
		int rightChildIndex=(2*parentIndex)+2;
		
		while(leftChildIndex<=ei){
			int minIndex=parentIndex;
			if(arr[leftChildIndex]<arr[minIndex]) {
				minIndex=leftChildIndex;
			}
			if(rightChildIndex<=ei && arr[rightChildIndex]<arr[minIndex]) {
				minIndex=rightChildIndex;
			}
			if(minIndex==parentIndex) {
				return;
			}
			int store=arr[minIndex];
			arr[minIndex]=arr[parentIndex];
			arr[parentIndex]=store;
			
			parentIndex=minIndex;
			leftChildIndex=(2*parentIndex)+1;
			rightChildIndex=(2*parentIndex)+2;
		}
		
	}
	
	public static void inplaceHeapSort(int arr[]) {
		
	}
	
	public static void main(String[] args) {
		int arr[]= {2,6,8,5,4,3};
		
		for(int i=(arr.length-1)/2;i>=0;i--) {
			downHeapify(i,arr,arr.length-1);
		}
		
		for(int i=0;i<arr.length;i++) {
			int store=arr[0];
			arr[0]=arr[arr.length-i-1];
			arr[arr.length-i-1]=store;
			downHeapify(0,arr,arr.length-i-2);
			//break;
//			downHeapify(i,arr,arr.length-i-2);
		}
		
		for(int i:arr) {
			System.out.println(i);
		}
	}
}
