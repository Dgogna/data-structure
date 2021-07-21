package dynamicProgramming;

public class EditDistIteratively {
	
	public static int editDistIte(String str1,String str2) {
		int dp[][]=new int[str1.length()+1][str2.length()+1];
		
		for(int i=0;i<=str2.length();i++) {
			dp[str1.length()][i]=str2.length()-i;
		}
		for(int i=0;i<=str1.length();i++) {
			dp[i][str2.length()]=str1.length()-i;
		}
		
		for(int i=str1.length()-1;i>=0;i--) {
			for(int j=str2.length()-1;j>=0;j--) {
				if(str1.charAt(i)==str2.charAt(j)) {
					dp[i][j]=dp[i+1][j+1];
				}else {
					int min=Math.min(dp[i+1][j+1], Math.min(dp[i+1][j], dp[i][j+1]));
					dp[i][j]=1+min;
				}
			}
		}
		
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		
		return dp[0][0];
	}

	public static void main(String[] args) {
		String str1="abd";
		String str2="bda";
		
		int ans=editDistIte(str1, str2);
		System.out.println(ans);
	}
}
