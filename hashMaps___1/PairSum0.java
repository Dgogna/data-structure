package hashMaps___1;
import java.util.*;
public class PairSum0 {
	
	public static int PairSum(int[] arr, int n) {
		
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }
        System.out.println(map.get(1));
        
        int sum=0;
        for(int i=0;i<arr.length;i++){
        	System.out.println(map.get(-arr[i]));
            if(map.containsKey(-arr[i])){
                sum+=map.get(arr[i])*map.get(-arr[i]);
                map.put(arr[i],0);
                map.put(-arr[i],0);
            }
        }
        return sum;
	}

	public static void main(String[] args) {
		int arr[]= {0,0,0,0};
		int ans=PairSum(arr,arr.length);
		System.out.println(ans);
	}
}
