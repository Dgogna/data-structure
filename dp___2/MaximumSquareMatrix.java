package dp___2;
import java.util.Scanner;
public class MaximumSquareMatrix {
	
	public static int maxSquare(int arr[][]) {
		int max=0;
		int n=arr.length;
		int m=arr[0].length;
		int dp[][]=new int[n][m];
		for(int i=0;i<n;i++) {
			if(arr[i][0]==0) {
				dp[i][0]=1;
				max=1;
			}else {
				dp[i][0]=0;
			}
		}
		for(int i=0;i<m;i++) {
			if(arr[0][i]==0) {
				dp[0][i]=1;
				max=1;
			}else {
				dp[0][i]=0;
			}
		}
		
		for(int i=1;i<n;i++) {
			for(int j=1;j<m;j++) {
				if(arr[i][j]==1) {
					dp[i][j]=0;
				}else {
					dp[i][j]=1+Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
					if(dp[i][j]>max) {
						max=dp[i][j];
					}
				}
			}
		}
		return max;
		
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
		
		int res=maxSquare(arr);
		System.out.println(res);

	}
}
