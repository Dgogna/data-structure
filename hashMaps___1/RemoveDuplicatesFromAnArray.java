package hashMaps___1;
import java.util.*;
public class RemoveDuplicatesFromAnArray {
	
	public static ArrayList<Integer> deleteDuplicates(int arr[]){
		ArrayList<Integer> res=new ArrayList<>();
		HashMap<Integer,Boolean> map=new HashMap<>();
		
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(arr[i])) {
				continue;
			}
			map.put(arr[i],true);
			res.add(arr[i]);
		}
//		Set<Integer> set=map.keySet();
//		for(int i:set) {
//			res.add(i);
//		}
		
		return res;
	}

	public static void main(String[] args) {
		int arr[]= {1,3,2,1,2,5,6,3,5,1};
		
		ArrayList<Integer> res=deleteDuplicates(arr);
		System.out.println(res);
	}
}
