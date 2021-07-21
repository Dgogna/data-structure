package dynamicProgramming;

public class MinimumSubsetSumDiff {
	
	public static boolean[][] isPresent(int arr[], int sum) {
		int n=arr.length;
		boolean dp[][]=new boolean[n+1][sum+1];
		
		for(int i=0;i<dp.length;i++) {
			dp[i][0]=true;
		}
		for(int i=1;i<dp[0].length;i++) {
			dp[0][i]=false;
		}
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				boolean ans1;
				if(j-arr[i-1]>=0) {
					ans1=dp[i-1][j-arr[i-1]];
				}else {
					ans1=false;
				}
				boolean ans2=dp[i-1][j];
				
				dp[i][j]=ans1||ans2;
			}
		}
		return dp;
//		return dp[n][sum];
	}

	public static int minSubsetSum(int arr[], boolean dp[][],int sum) {
		
//		int sum=0;
//		for(int i=0;i<arr.length;i++) {
//			sum+=arr[i];
//		}
//		System.out.println(sum);
		int ans=Integer.MAX_VALUE;
		for(int i=sum/2;i>=0;i--) {
//			System.out.println(isPresent(arr, i));
			if(dp[dp.length-1][i]==true) {
				ans=sum-2*i;
				break;
			}
//			if(isPresent(arr,i)) {
//				ans=sum-2*i;
//				break;
//			}
		}
		return Math.abs(ans);
	}
	
	public static void main(String[] args) {
		int arr[]= {1,6,11,5};
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
		}
		boolean dp[][]=isPresent(arr,sum/2);
//		for(int i=0;i<dp.length;i++) {
//			for(int j=0;j<dp[0].length;j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
		int ans=minSubsetSum(arr,dp, sum);
		System.out.println(ans);
		
//		boolean res=isPresent(arr, 11);
//		System.out.println(res);
	}
}
