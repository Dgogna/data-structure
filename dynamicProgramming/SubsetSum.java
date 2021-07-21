package dynamicProgramming;

public class SubsetSum {
	
	public static boolean subsetSumIte(int arr[], int sum) {
		int n=arr.length+1;
		int m=sum+1;
		boolean dp[][]=new boolean[arr.length+1][sum+1];
		
		for(int i=0;i<dp.length;i++) {
			dp[i][0]=true;
		}
		for(int i=0;i<dp[0].length;i++) {
			dp[0][i]=false;
		}
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[i].length;j++) {
				boolean b1;
				if(j-arr[i-1]>=0) {
					b1=dp[i-1][j-arr[i-1]];
				}else {
					b1=false;
				}
//				boolean b1=dp[i+1][sum-arr[i]];
				boolean b2=dp[i-1][j];
				dp[i][j]=b1||b2;
			}
		}
		
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				System.out.print(dp[i][j]+"  ");
			}
			System.out.println("\n");
		}
		
		return dp[dp.length-1][dp[0].length-1];
	}

	public static boolean subsetSum(int arr[], int i, int sum) {
		if(sum==0) {
			return true;
		}
		if(i==arr.length) {

			return false;
		}

		boolean b1=subsetSum(arr, i+1, sum-arr[i]);
		boolean b2=subsetSum(arr, i+1, sum);

		return b1||b2;
	}

	public static void main(String[] args) {
		int arr[]= {4,3,5,2};

		boolean res=subsetSum(arr, 0, 13);
		System.out.println(res+"\n");
		
		boolean res1=subsetSumIte(arr, 13);
		System.out.println(res1);
		
	}
}
