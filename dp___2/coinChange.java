package dp___2;

public class coinChange {
	
	public static int coinChangeIte(int arr[],int val) {
		int n=arr.length;
		int dp[][]=new int[n+1][val+1];
		
		for(int i=0;i<=val;i++) {
			dp[0][i]=0;
		}
		
		for(int i=0;i<=n;i++) {
			dp[i][0]=1;
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=val;j++) {
				if(arr[i-1]<=j) {
					dp[i][j]=dp[i-1][j]+dp[i][j-arr[i-1]];
				}else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp[n][val];
		
		
	}

	public static void main(String[] args) {
		int arr[]= {1,2,3};
		
		int ans=coinChangeIte(arr,4);
		System.out.println(ans);
	}
}
