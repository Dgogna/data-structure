package priorityQueue___1;

public class PrioRityQueueUse {
	public static void main(String[] args) throws PriorityQueueException {
		PriorityQueue<String> my=new PriorityQueue<>();
		my.insert("abc", 23);
		my.insert("sdsd", 2);
		my.insert("ght", 334);
		my.insert("jkljlk", 123);
		my.insert("hgjhgjgjhg", 34343);

		while(!my.isEmpty()) {


			System.out.println(my.getMin());
			my.removeMin();

		}
	}
}
