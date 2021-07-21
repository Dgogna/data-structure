package dynamicProgramming;

public class EditDistance {

	public static int editDistMemo(String str1,String str2,int i, int j, int dp[][]) {
//		System.out.println(i+" "+j);
		if(i==str1.length() ) {
//			System.out.println(str2.length()+"qweqw "+j);
			return str2.length()-j;
		}
		if(j==str2.length()) {
			return str1.length()-i;
		}

		int ans;
		if(str1.charAt(i)==str2.charAt(j)) {
			int smallAns;
			if(dp[i+1][j+1]==Integer.MAX_VALUE) {
				smallAns=editDistMemo(str1, str2,i+1,j+1,dp);
				dp[i+1][j+1]=smallAns;
			}else {
				smallAns=dp[i+1][j+1];
			}
			return smallAns;
		}
//		else {
			int ans1,ans2,ans3;
			if(dp[i+1][j+1]==Integer.MAX_VALUE) {
				ans1=editDistMemo(str1, str2, i+1, j+1, dp);
				dp[i+1][j+1]=ans1;
			}
			else {
				ans1=dp[i+1][j+1];		
			}

			if(dp[i+1][j]==Integer.MAX_VALUE) {
				ans2=editDistMemo(str1, str2, i+1, j, dp);
				dp[i+1][j]=ans2;
			}
			else {
				ans2=dp[i+1][j];		
			}

			if(dp[i][j+1]==Integer.MAX_VALUE) {
				ans3=editDistMemo(str1, str2, i, j+1, dp);
				dp[i][j+1]=ans3;
			}
			else {
				ans3=dp[i][j+1];		
			}
			
			
			
//			ans=Math.min(ans1, Math.min(ans2, ans3));
//		}

			return 1+Math.min(ans1, Math.min(ans2, ans3));
//		return ans;

		//return Math.min(ans1, Math.min(ans2, ans3));
	}

	public static int editDist(String str1, String str2, int i, int j) {
		if(i==str1.length()) {
			return str2.length()-j;
		}
		if(j==str2.length()) {
			return str1.length()-i;
		}

		if(str1.charAt(i)==str2.charAt(j)) {
			return editDist(str1, str2,i+1,j+1);
		}

		int ans1=1+editDist(str1, str2,i+1,j);
		int ans2=1+editDist(str1, str2,i,j+1);
		int ans3=1+editDist(str1, str2,i+1,j+1);

		
		return Math.min(ans1, Math.min(ans2, ans3));

	}

	public static void main(String[] args) {
		String str1="abcd";
		String str2="abd";
		int ans=editDist(str1, str2,0,0);
		System.out.println("ans 1 is"+ans);
		int dp[][]=new int[str1.length()+1][str2.length()+1];
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[i].length;j++) {
				dp[i][j]=Integer.MAX_VALUE;
			}
		}
		
		int ans1=editDistMemo(str1, str2, 0, 0, dp);
		System.out.println("ans 2 is "+ans1);
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[i].length;j++) {
				System.out.print(dp[i][j]+"  ");
			}
			System.out.println();
			System.out.println();
		}
	}
}
