package dynamicProgramming;

public class KnapSackIterative {
	
	public static int kanpSackIterative(int wt[], int val[], int W) {
		int n=val.length;
		int dp[][]=new int[n+1][W+1];
	
		for(int i=n-1;i>=0;i--) {
			for(int j=0;j<=W;j++) {
				int ans;
				if(wt[i]<=j) {
					ans=Math.max(dp[i+1][j],val[i]+dp[i][j-wt[i]]);
				}else {
					ans=dp[i+1][j];
				}
				dp[i][j]=ans;
			}
		}
		

		return dp[0][W];
	}

	public static void main(String[] args) {
		int weights[]= {20,25,30};
		int values[]= {200,300,100};
		int ans=kanpSackIterative(weights,values,50);
		System.out.println(ans);
	}
}
