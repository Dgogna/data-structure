package queue___1;

public class QueueUse {

	public static void main(String[] args)throws QueueEmptyException,QueueFullException {
		// TODO Auto-generated method stub
		//QueueUsingArray my=new QueueUsingArray();
		QueueUsingLL<Integer> my=new QueueUsingLL<>();
		int arr[]= {1,2,3,4,5,6,8,9};
		for(int x:arr) {
			my.enque(x);
		}
//		while(!my.isempty()) {
//			System.out.println(my.deque());
//		}
		while(!my.isempty()) {
			System.out.println(my.deque());
		}
		
//		System.out.println(my.front());
//		System.out.println(my.size());
//		my.deque();
//		System.out.println(my.front());
//		System.out.println(my.size());
		
		

	}

}
