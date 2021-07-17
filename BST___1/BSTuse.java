package BST___1;

public class BSTuse {

	public static void main(String[] args) {
		BST b=new BST();
		int arr[]= {5,3,6,2,4,7};
		for(int i:arr) {
			b.insert(i);
		}

//		b.insert(5);
//		b.insert(2);
//		b.insert(7);
//		b.insert(1);
//		b.insert(3);
//		b.insert(6);
//		b.insert(8);

		b.print();
//		System.out.println( b.isPresent(3));
//		System.out.println(b.deleteData(5));
////		System.out.println( b.isPresent(23));
//
//		b.print();
//		b.deleteData(2);
//		b.print();
	}
}
