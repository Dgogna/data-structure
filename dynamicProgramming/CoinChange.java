package dynamicProgramming;

public class CoinChange {
	
//	public static int coinChangeIte(int arr[], int val) {
//		int n=arr.length;
//		int dp[][]=new int [n+1][val+1];
//		
//		for(int i=0;i<dp.length;i++) {
//			dp[i][0]=1;
//		}
//		
//		for(int i=1;i<dp.length;i++) {
//			for(int j=1;j<=val;j++) {
//				if(arr[i-1]<=j) {
//					int ans1;
//					if(j-arr[i-1]<0) {
//						ans1=0;
//					}else {
//						ans1=dp[i][j-arr[i-1]];
//					}
////					int ans1=1+dp[i][j-arr[i]];
//					int ans2=dp[i-1][j];
////					int ans3=1+dp[i+1][j-arr[i]];
////					dp[i][j]=Math.max(ans1,ans2);
//					dp[i][j]=ans1+ans2;
//				}
//				else {
//					dp[i][j]=dp[i-1][j];
//				}
//			}
//		}
//		
////		for(int i=0;i<dp.length;i++) {
////			for(int j=0;j<dp[i].length;j++) {
////				System.out.print(dp[i][j]+" ");
////			}
////			System.out.println();
////		}
//		
//		return dp[n][val];
//	}
	
	public static int coinChange(int arr[], int si, int val) {
		if(si==arr.length) {
			if(val==0) {
				return 1;
//				count++;		
			}

			return 0;
		}
		
		if(arr[si]<=val) {
			int ans1=coinChange(arr, si+1, val-arr[si]);
			int ans2= coinChange(arr, si+1, val);
		    return ans1+ans2;
		}else {
			return coinChange(arr, si+1, val);
		}
	}

	public static void main(String[] args) {
		int arr[]= {2,3,5,6,8,10};
		int ans=coinChange(arr, 0, 10);
		System.out.println(ans);
		
//		int ans1=coinChangeIte(arr, 250);
//		System.out.println(ans1);
		
	}
}
