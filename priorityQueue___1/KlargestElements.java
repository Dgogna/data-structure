package priorityQueue___1;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;

public class KlargestElements {

	public static ArrayList<Integer> kLargest(int arr[], int k) {
		ArrayList<Integer> ans=new ArrayList<>();
		PriorityQueue<Integer> my=new PriorityQueue<>();

		for(int i=0;i<k;i++) {
			my.add(arr[i]);
		}
		//System.out.println(my.size());
		for(int i=k;i<arr.length;i++) {
			int ele=my.peek();
			if(arr[i]>ele) {
				//System.out.println(my.poll());
				my.poll();
				my.add(arr[i]);
			}
		}
		//System.out.println(my.size());
		while(!my.isEmpty()) {
			ans.add(my.poll());
		}
		
		return ans;

	}

	public static void main(String[] args) {
		int arr[]= {5,2,9,6,8,7,4,11,1,10,3};

		ArrayList<Integer> res=kLargest(arr,4);
		System.out.println(res);

	}
}
