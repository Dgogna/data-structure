package dynamicProgramming;

public class MinostIteratively {

	public static int minCostIteratively(int arr[][]) {
		int n=arr.length;
		int m=arr[0].length;
		int dp[][]=new int[n+1][m+1];
		
		for(int i=0;i<dp.length;i++) {
			dp[i][m]=Integer.MAX_VALUE;
		}
		for(int i=0;i<dp[0].length;i++) {
			dp[n][i]=Integer.MAX_VALUE;
		}
		
		for(int i=n-1;i>=0;i--) {
			for(int j=m-1;j>=0;j--) {
				int min=Math.min(dp[i][j+1], Math.min(dp[i+1][j+1], dp[i+1][j]));
				if(min==Integer.MAX_VALUE) {
					dp[i][j]=arr[i][j];
				}else {
					dp[i][j]=arr[i][j]+min;
				}
				
			}
		}

		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				System.out.print(dp[i][j]+"  ");
			}
			System.out.println("\n");
		}
		return dp[0][0];
	}
	
	public static void main(String[] args) {
		int arr[][]= {{1,5,11},{8,13,12},{2,3,7},{15,16,18}};
		int ans=minCostIteratively(arr);
		System.out.println(ans);
	}
}
