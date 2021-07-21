package dynamicProgramming;

public class MCM {
	
	public static int matrixChainMul(int arr[], int i, int j,int dp[][]) {
		if(i>=j) {
			return 0;
		}
		
		int res=Integer.MAX_VALUE;
		for(int k=i;k<=j-1;k++) {
			int ans1;
			if(dp[i][k]==-1) {
				ans1=matrixChainMul(arr, i, k,dp);
				dp[i][k]=ans1;
			}else {
				ans1=dp[i][k];
			}
	
			int ans2;
			if(dp[k+1][j]==-1) {
				ans2=matrixChainMul(arr, k+1, j,dp);
				dp[k+1][j]=ans2;
			}else {
				ans2=dp[k+1][j];
			}
		    int ans3=arr[i-1]*arr[k]*arr[j];
		    int temp=ans1+ans2+ans3;
		    if(temp<res) {
		    	res=temp;
		    }
		}
		return res;
		
	}
	
	public static int matrixChainMul(int arr[], int i, int j) {
		if(i>=j) {
			return 0;
		}
		
		int res=Integer.MAX_VALUE;
		for(int k=i;k<=j-1;k++) {
			int ans1=matrixChainMul(arr, i, k);
			int ans2=matrixChainMul(arr, k+1, j);
		    int ans3=arr[i-1]*arr[k]*arr[j];
		    int temp=ans1+ans2+ans3;
		    if(temp<res) {
		    	res=temp;
		    }
		}
		return res;
		
	}

	public static void main(String[] args) {
		int arr[]= {40,20,30,10,30};
		int ans=matrixChainMul(arr, 1, arr.length-1);
		System.out.println(ans);
		int dp[][]=new int[arr.length+1][arr.length+1];
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp.length;j++) {
				dp[i][j]=-1;
			}
		}
	
		int ans1=matrixChainMul(arr, 1, arr.length-1,dp);

		System.out.println(ans1);
	}
}
