package priorityQueue___1;

public class HeapSort {
	
	public static void downHeapify(int n,int arr[], int ei) {
		int parentIndex=n;
		int childIndex1=2*parentIndex+1;
		int childIndex2=2*parentIndex+2;
		while(childIndex1<=ei) {
			int min=parentIndex;
			if(arr[childIndex1]<arr[min]) {
				min=childIndex1;
			}
			if(childIndex2<=ei && arr[childIndex2]<arr[min]) {
				min=childIndex2;
			}
			if(min==parentIndex) {
				return;
			}
			int store=arr[min];
			arr[min]=arr[parentIndex];
			arr[parentIndex]=store;
			
			parentIndex=min;
			childIndex1=2*parentIndex+1;
			childIndex2=2*parentIndex+2;
			
		}
	}

	public static void main(String[] args) {
		int arr[]= {5,12,10,3,7,4,1,6,8,9};
		int n=arr.length;
		for(int i=n/2-1;i>=0;i--) {
			downHeapify(i, arr,arr.length-1);
		}
		for(int i:arr) {
			System.out.print(i+" ");
		}
		System.out.println();
		for(int i=0;i<n;i++) {
			int store=arr[0];
			arr[0]=arr[n-i-1];
			arr[n-i-1]=store;
			downHeapify(0, arr,n-i-2);
			
		}
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}
}
