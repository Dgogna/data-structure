package dp___2;
import java.util.Scanner;
public class EditDistance {
	
	public static int minEditDisIte(String str1, String str2) {
		int n=str1.length();
		int m=str2.length();
		
		int dp[][]=new int[n+1][m+1];
		
		for(int i=0;i<=n;i++) {
			dp[i][0]=i;
		}
		for(int i=0;i<=m;i++) {
			dp[0][i]=i;
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(str1.charAt(i-1)==str2.charAt(j-1)) {
					dp[i][j]=dp[i-1][j-1];
				}else {
					int ans1=dp[i][j-1];
					int ans2=dp[i-1][j];
					int ans3=dp[i-1][j-1];
					
					int ans=Math.min(ans1, Math.min(ans2, ans3));
					dp[i][j]=1+ans;
				}
			}
		}
		return dp[n][m];
		
	}
	
	public static int minEditDistance(String str1,String str2,int i, int j) {
		if(i==str1.length()) {
			return str2.length()-j;
		}else if(j==str2.length()) {
			return str1.length()-i;
		}
		
		if(str1.charAt(i)==str2.charAt(j)) {
			return minEditDistance(str1, str2, i+1, j+1);
		}
		
		int dist1=1+minEditDistance(str1, str2, i+1, j+1);
		int dist2=1+minEditDistance(str1, str2, i+1, j);
		int dist3=1+minEditDistance(str1, str2, i , j+1);
		
		int ans=Math.min(dist1, Math.min(dist2, dist3));
		return ans;
	}

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str1=s.next();
		String str2=s.next();
		
		int editDist=minEditDistance(str1,str2,0,0);
		System.out.println(editDist);
		int res=minEditDisIte(str1, str2);
		System.out.println(res);
	}
}
