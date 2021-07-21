package dynamicProgramming;

public class MagicGrid {
	
	public static int magicgridmemo(int arr[][], int i, int j, int dp[][]) {
		if(i==arr.length-1 && j==arr[0].length-1) {
			return 1;
		}
		
		if(i>=arr.length || j>=arr[0].length) {
			return Integer.MAX_VALUE;
		}
		
		int ans1;
		if(dp[i][j+1]==Integer.MAX_VALUE) {
			ans1=magicgridmemo(arr, i, j+1, dp);
			dp[i][j+1]=ans1;
		}else {
			ans1=dp[i][j+1];
		}
		int ans2;
		if(dp[i+1][j]==Integer.MAX_VALUE) {
			ans2=magicgridmemo(arr, i+1, j, dp);
			dp[i+1][j]=ans2;
		}else {
			ans2=dp[i+1][j];
		}
		
		int res=Math.min(ans1, ans2);
		if(arr[i][j]>=res) {
			return 1;
		}
		return res-arr[i][j];
		
	}
	
	public static int magicGrid(int arr[][], int i, int j) {
		
		if(i==arr.length-1 && j==arr[0].length-1) {
			return 1;
		}
		
		if(i>=arr.length || j>=arr[0].length) {
			return Integer.MAX_VALUE;
		}
		
		int ans1=magicGrid(arr, i, j+1);
		int ans2=magicGrid(arr, i+1, j);
		
		int res=Math.min(ans1, ans2);
		if(arr[i][j]>=res) {
			return 1;
		}
		return res-arr[i][j];
	}
	
	public static void main(String[] args) {
//		int arr[][]= {{0,1,-3},{1,-2,0}};
//		int arr[][]= {{0,1},{2,0}};
		int arr[][]= {{0,-2,-3,1},{-1,4,0,-2},{1,-2,-3,0}};
		int dp[][]=new int[arr.length+1][arr[0].length+1];
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				dp[i][j]=Integer.MAX_VALUE;
			}
		}
		int ans1=magicGrid(arr, 0, 0);
		int ans2=magicgridmemo(arr, 0, 0, dp);
		System.out.println(ans1+" "+ans2);
		
	}
}
