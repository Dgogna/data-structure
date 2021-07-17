package hashMaps___1;
import java.util.*;
public class MaxFrequencynoInArray {
	
	public static int maxFrequencyNumber(int[] arr) {
		HashMap<Integer,Integer> map=new HashMap<>();
		int val=1;
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(arr[i])) {
				int oldVal=map.get(arr[i]);
				map.put(arr[i], oldVal+1);
			}else {
				map.put(arr[i], val);
			}
			
		}
		
		int maxFreq=0;
		int max=Integer.MIN_VALUE;
		for(int i:arr) {
			if(map.get(i)>maxFreq) {
				max=i;
				maxFreq=map.get(i);
			}
		}
		
		return max;
		
	}

	public static void main(String[] args) {
		
		int[] arr= {2,12,2,11,12,2,1,2,2,11,12,2,6};
		
		int ans=maxFrequencyNumber(arr);
		System.out.println(ans);
	}
}
