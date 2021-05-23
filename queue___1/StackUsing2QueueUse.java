package queue___1;

public class StackUsing2QueueUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StackUsing2Queues my=new StackUsing2Queues();
		my.push(1);
		my.push(2);
		my.push(3);
		my.push(4);
		
		System.out.println(my.poll());
		System.out.println(my.top());
		System.out.println(my.poll());
		my.push(5);
		System.out.println(my.top());
		System.out.println(my.poll());
		System.out.println(my.poll());

	}

}
