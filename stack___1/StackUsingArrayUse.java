package stack___1;

public class StackUsingArrayUse {

	public static void main(String[] args) throws StackEmptyException, StackFullException {
		// TODO Auto-generated method stub
		
		StackUsingArray my=new StackUsingArray();
		my.push(1);
		my.push(2);
		my.push(3);
		my.push(4);
		my.push(5);
		my.push(6);
		my.push(7);
		my.push(8);
		my.push(9);
		my.push(10);
		my.push(11);
		
		
		System.out.println(my.top());
		System.out.println(my.pop());
		System.out.println(my.top());
		System.out.println(my.size());
		System.out.println(my.isempty());

	}

}
