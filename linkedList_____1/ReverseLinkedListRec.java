package linkedList_____1;
import java.util.*;

class DoubleNode {
	Node<Integer> head;
	Node<Integer> tail;

	DoubleNode(Node<Integer> head, Node<Integer> tail){
		this.head=head;
		this.tail=tail;
	}
}
public class ReverseLinkedListRec {

	static Node<Integer> takeinput(){
		Scanner s=new Scanner(System.in);
		int data=s.nextInt();	
		Node<Integer> head=null;
		Node <Integer> tail=null;
		while(data!=-1){
			Node<Integer> toadd=new Node<>(data);
			if(head==null) {
				head=toadd;
				tail=toadd;
			}
			else {
				tail.next=toadd;
				tail=tail.next;
			}
			data=s.nextInt();
		}
		return head;	
	}

	static Node<Integer> reverse(Node<Integer> head) {
		if(head==null || head.next==null) {
			return head;
		}

		Node<Integer> smallhead=reverse(head.next);

		Node<Integer> temp=smallhead;
		// we are doing this task repetedly
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=head;
		head.next=null;

		return smallhead;
	}

	static DoubleNode reverseBetter(Node<Integer> head) {
		// my;
		if(head==null || head.next==null) {
			DoubleNode my=new DoubleNode(head,head);
			return my;
		}

		DoubleNode smallhead=reverseBetter(head.next);

		smallhead.tail.next=head;
		head.next=null;

		DoubleNode ans=new DoubleNode(smallhead.head,head);

		return ans;
	}

	static Node<Integer> reverseBest(Node<Integer> head){
		if(head==null || head.next==null) {
			return head;
		}

		Node<Integer> shorthead=reverseBest(head.next);
		Node<Integer> tail=head.next;
		tail.next=head;
		head.next=null;

		return shorthead;
	}

	static void print(Node<Integer> head) {
		Node<Integer> temp=head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head=takeinput();
		//		head=reverse(head);
		//		print(head);

		//		DoubleNode res=reverseBetter(head);
		head=reverseBest(head);
		print(head);

	}

}
