package dp___2;
import java.util.Scanner;
public class lcs {
	
	public static int lcsIterative(String str1,String str2) {
		int n=str1.length();
		int m=str2.length();
		int dp[][]=new int[n+1][m+1];
		
		for(int i=n-1;i>=0;i--) {
			for(int j=m-1;j>=0;j--) {
				if(str1.charAt(i)==str2.charAt(j)) {
					dp[i][j]=1+dp[i+1][j+1];
				}else {
					dp[i][j]=Math.max(dp[i+1][j], dp[i][j+1]);
				}
			}
		}
		return dp[0][0];
	}

	public static int lcs(String str1,String str2, int i, int j) {
		if(i==str1.length() || j==str2.length()) {
			return 0;
		}

		if(str1.charAt(i)==str2.charAt(j)) {
			return 1+lcs(str1, str2, i+1, j+1);
		}
		int ans=Math.max(lcs(str1, str2, i+1, j), lcs(str1, str2, i, j+1));
		
		return ans;

	}

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str1=s.next();
		String str2=s.next();
		
		int lcs=lcs(str1, str2, 0, 0);
		System.out.println(lcs);
		int res=lcsIterative(str1, str2);
		System.out.println(res);
	}
}
