package dynamicProgramming;

public class MaxSquareMatrixWithZero {
	
	public static int maxZero(int[][] arr) {
		int dp[][]=new int[arr.length][arr.length];
		int max=0;
//		for(int i=0;i<arr.length;i++) {
//			if(arr[i][0]==0) {
//				dp[i][0]=1;
//			}else {
//				dp[i][0]=0;
//			}
//			if(dp[i][0]>max) {
//				max=dp[i][0];
//			}
//			
//			if(arr[0][i]==0) {
//				dp[0][i]=1;
//			}else {
//				dp[0][i]=0;
//			}
//			if(dp[0][i]>max) {
//				max=dp[0][i];
//			}
//		}
		
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[i].length;j++) {
				if(arr[i][j]==0) {
					dp[i][j]=1;
				}else {
					dp[i][j]=0;
				}
				if(dp[i][j]>max) {
					max=dp[i][j];
				}
			}
		}

		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[i].length;j++) {
				if(arr[i][j]==0) {
					int min=Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
					dp[i][j]=1+min;
				}else {
					dp[i][j]=0;
				}
				if(dp[i][j]>max) {
					max=dp[i][j];
				}
			}
		}
		
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp.length;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		
		return max;
	}

	public static void main(String[] args) {
		int arr[][]= {{9,1,0},{1,1,1},{1,2,3}};
		
		int ans=maxZero(arr);
		System.out.println(ans);
		
		
	}
}
