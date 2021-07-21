package dynamicProgramming;

public class KnapSack {
	
	public static int knapSackMemo(int weight[], int value[], int i, int maxWeight,int dp[][]) {
		if(i==weight.length) {
			return 0;
		}
		int res;
		if(weight[i]<=maxWeight) {
			int ans1, ans2;
			if(dp[i+1][maxWeight-weight[i]]==-1) {
				ans1=knapSackMemo(weight, value, i+1, maxWeight-weight[i], dp);
				dp[i+1][maxWeight-weight[i]]=ans1;
			}else {
				ans1=dp[i+1][maxWeight-weight[i]];
			}
			
			if(dp[i+1][maxWeight]==-1) {
				ans2=knapSackMemo(weight, value, i+1, maxWeight, dp);
				dp[i+1][maxWeight]=ans2;
			}else {
				ans2=dp[i+1][maxWeight];
			}
			
			res=Math.max(ans1+value[i], ans2);
		}else {
			int ans1;
			if(dp[i+1][maxWeight]==-1) {
				ans1=knapSackMemo(weight, value, i+1, maxWeight, dp);
				dp[i+1][maxWeight]=ans1;
			}else {
				ans1=dp[i+1][maxWeight];
			}
			res=ans1;
		}
		return res;
	}

	public static int knapSack(int weights[], int values[], int n,int i, int maxWeight) {
		if(i==weights.length) {
			return 0;
		}
		
		int res;

		if(weights[i]<=maxWeight) {
			int ans1=values[i]+knapSack(weights, values, n, i+1, maxWeight-weights[i]);
			int ans2=knapSack(weights, values, n, i+1, maxWeight);
			
			res=Math.max(ans1, ans2);
		}else {
			res=knapSack(weights, values, n, i+1, maxWeight);
			
		}

		return res;
	}
	
	public static void main(String[] args) {
		int weights[]= {1,1,1};
		int values[]= {10,20,30};
		int n=weights.length;
		int m=2;
		int ans=knapSack(weights, values, n, 0, m);
		System.out.println(ans);
		int dp[][]=new int[weights.length+1][m+1];
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[i].length;j++) {
				dp[i][j]=-1;
			}
		}
		int ans1=knapSackMemo(weights, values, 0, m, dp);
		System.out.println(ans1+"\n");
		
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[i].length;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
	}
}
