package dp___2;

public class knapsack {
	
	public static int knapsackIte(int weight[], int val[], int w) {
		int n=weight.length;
		
		int dp[][]=new int[n+1][w+1];
		
		for(int i=n-1;i>=0;i--) {
			for(int j=0;j<=50;j++) {
				if(weight[i]<=j) {
					int ans1=val[i]+dp[i+1][j-weight[i]];
					int ans2=dp[i+1][j];
					
					dp[i][j]=Math.max(ans1, ans2);
				}else {
					dp[i][j]=dp[i+1][j];
				}
			}
		}
		return dp[0][w];
	}

	
	public static int knapsack(int weight[], int val[], int si, int W) {
		if(si==weight.length) {
			return 0;
		}
		
		if(weight[si]<=W) {
			int ans1=val[si]+knapsack(weight, val, si+1, W-weight[si]);
			int ans2=knapsack(weight, val, si+1, W);
			return Math.max(ans1, ans2);
		}
		
		int ans=knapsack(weight, val, si+1, W);
		return ans;
		
	}
	
	public static void main(String[] args) {
		int weights[]= {20,25,30};
		int values[]= {200,300,100};
		
		int ans=knapsack(weights, values, 0, 50);
		System.out.println(ans);
		int res=knapsackIte(weights, values, 50);
		System.out.println(res);
	}
}
