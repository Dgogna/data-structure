package priorityQueue___1;

public class MaxPriorityQueueUse {
	public static void main(String[] args) {
		MaxPriorityQueue my=new MaxPriorityQueue();
		my.insert(100);
		my.insert(80);
		my.insert(90);
		my.insert(70);
		my.insert(50);
		my.insert(60);
		my.insert(85);

//		System.out.println(my.removeMax());
//		System.out.println(my.removeMax());
//		System.out.println(my.removeMax());
		
		while(!my.isEmpty()) {

			System.out.println(my.removeMax());
			
			

		}
	}
}
