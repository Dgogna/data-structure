package stack___1;

public class StackUsingLL_Use {

	public static void main(String[] args) throws StackEmptyException {
		// TODO Auto-generated method stub
		
		StackUsingLL<String> my=new StackUsingLL<>();
		my.push("Dhruv");
		my.push("Soumil");
		my.push("Suket");
		my.push("Watali");
		
		
		
		System.out.println(my.size());
		System.out.println(my.top());
		my.pop();
		System.out.println(my.top());
		System.out.println(my.size());
		my.pop();
		my.pop();
		
		System.out.println(my.size());
		System.out.println(my.top());
		

	}

}
