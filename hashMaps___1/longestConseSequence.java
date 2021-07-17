package hashMaps___1;
import java.util.*;
public class longestConseSequence {

	public static ArrayList<Integer> longestSeq(int arr[]){
		
		ArrayList<Integer> slist=new ArrayList<>();
        ArrayList<Integer> elist=new ArrayList<>();
        
		HashMap<Integer,Integer> map=new HashMap<>();
		
		for(int i=0;i<arr.length;i++) {
			map.put(arr[i], i);
		}
		int ans=0;
		for(int i=0;i<arr.length;i++) {
			int count=0;
			int start=arr[i];
			if(map.containsKey(arr[i]-1)) {
				continue;
			}else {
				int val=arr[i];
				while(map.containsKey(val)) {
					count++;
					val++;
				}
				if(count>=ans) {
					ans=count;
					slist.add(start);
					elist.add(start+count-1);
//					System.out.println(start+" "+(start+count-1));
				}
			}
		}
//		System.out.println("max length is "+ans);
		ArrayList<Integer> partialRes=new ArrayList<>();
		for(int i=0;i<slist.size();i++) {
			if(elist.get(i)-slist.get(i)==ans-1) {
				partialRes.add(slist.get(i));
			}
		}
		
		int before=Integer.MAX_VALUE;
		for(int i=0;i<partialRes.size();i++) {
			if(map.get(partialRes.get(i))<before) {
				before=map.get(partialRes.get(i));
			}
		}
		
		ArrayList<Integer> Res=new ArrayList<>();
		Res.add(arr[before]);
		Res.add(arr[before]+ans-1);
		
		
		return Res;
		
	}
	
	public static void main(String[] args) {
		int arr[]= {2, 12, 9 ,16, 10, 5 ,3 ,20, 25, 11, 1 ,8 ,6 }; 
		ArrayList<Integer> res=longestSeq(arr);
		for(int i=0;i<res.size();i++) {
			System.out.print(res.get(i)+" ");
		}
	}
}
