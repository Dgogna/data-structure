package queue___1;
import java.util.*;
public class StackUsing2Queues {
	
	Queue<Integer> q1;
	Queue<Integer> q2;
	
	StackUsing2Queues(){
		q1=new LinkedList<>();
		q2=new LinkedList<>();
	}
	
	public void push(int ele) {
		q1.add(ele);
	}
	
	public int poll() {
		while(q1.size()>1) {
			q2.add(q1.poll());
		}
		Queue<Integer>q=q1;
		q1=q2;
		q2=q;
		return q2.poll();
	}
	
	public int top() {
		while(q1.size()>1) {
			q2.add(q1.poll());
		}
		int ans=q1.poll();
		q2.add(ans);
		Queue<Integer>q=q1;
		q1=q2;
		q2=q;
		
		return ans;
	}

}
