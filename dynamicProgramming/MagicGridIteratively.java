package dynamicProgramming;

public class MagicGridIteratively {

	public static int magicGridIte(int arr[][]) {
		int n=arr.length;
		int m=arr[0].length;
		int dp[][]=new int[n+1][m+1];
		
		dp[n][m]=1;
		dp[n][m-1]=1;
		dp[n-1][m]=1;
		for(int i=m-2;i>=0;i--) {
			dp[n][i]=arr[n-1][i]-dp[n][i+1];
		}
		for(int i=n-2;i>=0;i--) {
			dp[i][m]=arr[i][m-1]-dp[i+1][m];
		}
		int k=0;
		for(int i=n-1;i>=0;i--) {
			for(int j=m-1;j>=0;j--) {
				int ans=Math.min(dp[i][j+1]-arr[i][j+1], dp[i+1][j]-arr[i+1][j]);
				dp[i][j]=Math.abs(ans);
			}
		}
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[i].length;j++) {
				System.out.print(dp[i][j]+"  ");
			}
			System.out.println("\n");
		}
		
		return 2;
	}
	
	public static void main(String[] args) {
		
//		int arr[][]= {{0,1,-3},{1,-2,0}};
//		int arr[][]= {{0,1},{2,0}};
		int arr[][]= {{0,-2,-3,1},{-1,4,0,-2},{1,-2,-3,0}};
		
		int ans=magicGridIte(arr);
		System.out.println(ans);
	}
}
