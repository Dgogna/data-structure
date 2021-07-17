package recursion___2;
import java.util.*;
public class PrintSubsetsArray {
	
	public static void printSubsets(int arr[], int si,String str) {
		if(si==arr.length) {
			System.out.println(str);
			return;
		}
		
		printSubsets(arr,si+1,str);
		printSubsets(arr,si+1,str+arr[si]+" ");
	}
	
	public static void main(String[] args) {
		int arr[]= {1,2,3};
		//ArrayList<Integer> my=new ArrayList<>();
		printSubsets(arr,0,"");
	}
	
}
