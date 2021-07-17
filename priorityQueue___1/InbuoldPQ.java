package priorityQueue___1;
import java.util.PriorityQueue;

public class InbuoldPQ {
	public static void main(String[] args) {
		int arr[]= {100,20,40,30,50,70,90};
		
		PriorityQueue<Integer> my=new PriorityQueue<>();
		for(int i=0;i<arr.length;i++) {
			my.add(arr[i]);
		}
		
		System.out.println(my);
		System.out.println();
		while(!my.isEmpty()) {
			System.out.print(my.poll()+" ");
		}
		
	}
}
