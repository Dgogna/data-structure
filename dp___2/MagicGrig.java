package dp___2;

import java.util.Scanner;

public class MagicGrig {
	
	public static int minHealthIte(int arr[][]) {
		int n=arr.length;
		int m=arr[0].length;
		int dp[][]=new int[n+1][m+1];
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=m;j++) {
				dp[i][j]=Integer.MAX_VALUE;
			}
		}
		
		for(int i=n-1;i>=0;i--) {
			for(int j=m-1;j>=0;j--) {
				int right=dp[i][j+1];
				int down=dp[i+1][j];
				if(right==Integer.MAX_VALUE && down==Integer.MAX_VALUE) {
					dp[i][j]=1;
				}else {
					int res=Math.min(right, down);
					if(arr[i][j]>=res) {
						dp[i][j]=1;
					}else {
						dp[i][j]=res-arr[i][j];
					}
				}
				
			}
		}
		return dp[0][0];
	}

	public static int minHealth(int arr[][], int i, int j) {
		int n=arr.length;
		int m=arr[0].length;
		if(i==n-1 && j==m-1) {
			return 1;
		}
		if(i>=n || j>=m) {
			return Integer.MAX_VALUE;
		}

		int right=minHealth(arr, i, j+1);
		int left=minHealth(arr, i+1, j);
		int res=Math.min(right, left);
		if(arr[i][j]>=res) {
			return 1;
		}
		return res-arr[i][j];
	}

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);

		int n=s.nextInt();
		int m=s.nextInt();
		int arr[][]=new int[n][m];

		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				arr[i][j]=s.nextInt();
			}
		}
		int ans=minHealth(arr, 0, 0);
		System.out.println(ans);
		int res=minHealthIte(arr);
		System.out.println(res);
	}
}
