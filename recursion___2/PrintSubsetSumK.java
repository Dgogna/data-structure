package recursion___2;

public class PrintSubsetSumK {
	
	public static void printSubsetsK(int arr[],int si,int k, String str) {
		if(si==arr.length) {
			if(k==0) {
				System.out.println(str);
				return;
			}else {
				return;
			}
		}
		printSubsetsK(arr,si+1,k-arr[si],str+arr[si]+" ");
		printSubsetsK(arr,si+1,k,str);
		
	}
	
	public static void main(String[] args) {
		int arr[]= {3,2,5,1,4,6};
		printSubsetsK(arr,0,8,"");
	}
	
}
