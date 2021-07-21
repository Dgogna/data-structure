package dynamicProgramming;

public class StairCase {
	
	public static long stairCaseI(int n) {
		long arr[]=new long[n+1];
		arr[1]=1;
		arr[2]=2;
		arr[3]=4;
		
		for(int i=4;i<=n;i++) {
			arr[i]=arr[i-1]+arr[i-2]+arr[i-3];
		}
		
		return arr[n];
	}
	
	public static long stairCase(int n) {
		if(n==1 || n==2) {
			return n;
		}
		if(n==3) {
			return 4;
		}
		long ans1=stairCase(n-1);
		long ans2=stairCase(n-2);
		long ans3=stairCase(n-3);
		
		return ans1+ans2+ans3;
		
	}

	public static void main(String[] args) {
		long ans=stairCase(5);
		System.out.println(ans);
		
		long ans1=stairCaseI(5);
		System.out.println(ans1);
		
	}
	
}
