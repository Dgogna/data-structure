package dynamicProgramming;

public class MinCostMemo {
	
	public static int minCostMemo(int[][] arr, int i, int j, int dp[][]) {
		int n=arr.length;
		int m=arr[0].length;
		// special case
		if(i==n-1 && j==m-1) {
			return arr[i][j];
		}
		// base case
		if(i>=n || j>=m) {
			return Integer.MAX_VALUE;
		}
		
		int ans1;
		if(dp[i][j+1]==Integer.MIN_VALUE) {
			ans1=minCostMemo(arr, i, j+1, dp);
			dp[i][j+1]=ans1;
		}else {
			ans1=dp[i][j+1];
		}
		
		int ans2;
		if(dp[i+1][j+1]==Integer.MIN_VALUE) {
			ans2=minCostMemo(arr, i+1, j+1, dp);
			dp[i+1][j+1]=ans2;
		}else {
			ans2=dp[i+1][j+1];
		}
		
		int ans3;
		if(dp[i+1][j]==Integer.MIN_VALUE) {
			ans3=minCostMemo(arr, i+1, j, dp);
			dp[i+1][j]=ans3;
		}else {
			ans3=dp[i+1][j];
		}
		
		int min=Math.min(ans1, Math.min(ans2, ans3));
		return min+arr[i][j];
		
	}

	public static void main(String[] args) {
		int arr[][]= {{1,5,11},{8,13,12},{2,3,7}};
//		int arr[][]= {{1,2},{3,4}};
		int dp[][]=new int[arr.length+1][arr[0].length+1];
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				dp[i][j]=Integer.MIN_VALUE;
			}
		}
		
		int ans=minCostMemo(arr, 0, 0, dp);
		
		System.out.println(ans);
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				System.out.print(dp[i][j]+"  ");
			}
			System.out.println("\n");
		}
	}
}
