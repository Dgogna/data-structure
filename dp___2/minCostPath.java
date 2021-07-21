package dp___2;
import java.util.Scanner;
public class minCostPath {
	
	public static int minCostIte(int arr[][]) {
		int n=arr.length;
		int m=arr[0].length;
		
		int dp[][]=new int[n+1][m+1];
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<m+1;j++) {
				dp[i][j]=Integer.MAX_VALUE;
			}
		}
		
		for(int i=n-1;i>=0;i--) {
			for(int j=m-1;j>=0;j--) {
				int res=Math.min(dp[i][j+1], Math.min(dp[i+1][j+1], dp[i+1][j]));
				if(res==Integer.MAX_VALUE) {
					dp[i][j]=arr[i][j];
				}else {
					dp[i][j]=arr[i][j]+res;
				}
			}
		}
		
		return dp[0][0];
	}

	public static int minCost(int arr[][], int i, int j) {
		int n=arr.length;
		int m=arr[0].length;
		
		if(i==n-1 && j==m-1) {
			return arr[i][j];
		}
		if(i>=n || j>=m) {
			return Integer.MAX_VALUE;
		}
		
		int cost1=minCost(arr, i, j+1);
		int cost2=minCost(arr, i+1, j+1);
		int cost3=minCost(arr, i+1, j);
		
		int ans=arr[i][j]+Math.min(cost1,Math.min(cost2, cost3));
		return ans;
		
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int m=s.nextInt();
		int arr[][]= new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				arr[i][j]=s.nextInt();
			}
		}
		int res=minCost(arr, 0, 0);
		System.out.println(res);
		int ans=minCostIte(arr);
		System.out.println(ans);
	}
}
