package dynamicProgramming;

public class LCSmemo {
	
	public static int largestCommonSubseq(String str1, String str2, int i, int j, int dp[][]) {
		if(i==str1.length() || j==str2.length()) {
			return 0;
		}
		
		int ans;
		if(str1.charAt(i)==str2.charAt(j)) {
			int smallAns;
			if(dp[i+1][j+1]==-1) {
				smallAns=largestCommonSubseq(str1, str2, i+1, j+1, dp);
				dp[i+1][j+1]=smallAns;
			}else {
				smallAns=dp[i+1][j+1];
			}
			
			ans=1+smallAns;
		}
		else {
			int ans1;
			int ans2;
			if(dp[i][j+1]==-1) {
				ans1=largestCommonSubseq(str1, str2, i, j+1, dp);
				dp[i][j+1]=ans1;
			}else{
				ans1=dp[i][j+1];
			}
			
			if(dp[i+1][j]==-1) {
				ans2=largestCommonSubseq(str1, str2, i+1, j, dp);
				dp[i+1][j]=ans2;
			}else {
				ans2=dp[i+1][j];
			}
			
			ans=Math.max(ans1, ans2);
		}
		
		return ans;
	}

	public static void main(String[] args) {
		String str1="abedgjc";
		String str2="bmdgsc";
		int dp[][]=new int[str1.length()+1][str2.length()+1];
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[i].length;j++) {
				dp[i][j]=-1;
			}
		}
			
		int ans=largestCommonSubseq(str1, str2,0,0,dp);
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[i].length;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(ans);
	}
}
