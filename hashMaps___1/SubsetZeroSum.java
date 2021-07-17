package hashMaps___1;
import java.util.*;
public class SubsetZeroSum {
	
	public static int zeroSum(int arr[]) {
		HashMap<Integer,Integer> map=new HashMap<>();
		int sum=0;
		int ans=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
			if(sum==0) {
				ans=Math.max(ans, i+1);
			}
			else if(map.containsKey(sum)) {
//				System.out.println(i+" "+sum);
				ans=Math.max(ans, i-map.get(sum));
			}
			else {
				map.put(sum,i);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int arr[]= {1 ,2 ,3 ,4 ,-10, 10};
		int ans=zeroSum(arr);
		System.out.println(ans);
	}
}
