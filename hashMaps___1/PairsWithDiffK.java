package hashMaps___1;
import java.util.*;
public class PairsWithDiffK {
	
	public static int getPairsWithDifferenceK(int arr[], int k) {
		//Write your code here
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++) {
        	if(map.containsKey(i)){
              map.put(arr[i],map.get(arr[i])+1);          
          }else {
        	  map.put(arr[i],1);
          }
         
        }
//        for(int i:arr){
//            if(map.containsKey(i)){
//                map.put(i,map.get(i)+1);          
//            }
//           map.put(i,1);  
//        }
        
        int count=0;
        
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i]-k) && map.get(arr[i]-k)>0){
                count+=map.get(arr[i])*map.get(arr[i]-k);
                map.put(arr[i],0);
                map.put(arr[i]-k,0);
            }
        }
        return count;
        
	}

	public static void main(String[] args) {
		
	}
}
