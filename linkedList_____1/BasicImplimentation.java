package linkedList_____1;
import java.util.*;
public class BasicImplimentation {
	
	static Node<Integer> takeinput(){
		Scanner s=new Scanner(System.in);
		int val=s.nextInt();
		Node<Integer> head=null,  tail=null;
		while(val!=-1) {
			Node <Integer> currnode=new Node<>(val);
			if(head==null) {
				head=currnode;
				tail=currnode;
			}else {
//				Node<Integer> temp=head;
//				while(temp.next!=null) {
//					temp=temp.next;
//				}
//				temp.next=currnode;
				tail.next=currnode;
				tail=tail.next;
			}
			
			val=s.nextInt();
		}
		
		return head;
	}
	
	static void print(Node<Integer> head) {
		while(head!=null) {
			System.out.print(head.data+" ");
			head=head.next;
		}
	}
	
	static Node<Integer> insert(Node<Integer> head,int val, int pos) {
		Node <Integer> toadd=new Node<>(val);
		if(pos==0) {
			toadd.next=head;
			//head=toadd;
			return toadd;
		}else {
			int count=0;
			
			Node<Integer> temp=head;
			while(count<pos-1 && temp!=null) {
				count++;
				temp=temp.next;
			}
			toadd.next=temp.next;
			temp.next=toadd;
		}
		
		return head;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node<Integer> head=takeinput();
		print(head);
		System.out.println();
		head=insert(head,20,3);
		print(head);
		

	}

}
