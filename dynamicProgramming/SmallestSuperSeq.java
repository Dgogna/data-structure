package dynamicProgramming;

public class SmallestSuperSeq {
	
	public static int smallestSuperIte(String str1,String str2) {
		int dp[][]=new int[str1.length()+1][str2.length()+1];
		
		for(int i=str1.length()-1;i>=0;i--) {
			for(int j=str2.length()-1;j>=0;j--) {
				if(str1.charAt(i)==str2.charAt(j)) {
					dp[i][j]=1+dp[i+1][j+1];
				}else {
					dp[i][j]=2+Math.min(dp[i+1][j], dp[i][j+1]);
				}
			}
		}
		return dp[0][0];
	}
	
	public static int smallestSuperSeqence(String str1, String str2, int i, int j) {
		if(i==str1.length() || j==str2.length()) {
			return 0;
		}
		if(str1.charAt(i)==str2.charAt(j)) {
			return 1+smallestSuperSeqence(str1,str2,i+1,j+1);
		}
		return 2+Math.min(smallestSuperSeqence(str1, str2, i+1, j), smallestSuperSeqence(str1, str2, i, j+1));
	}

	public static void main(String[] args) {
		String str1="ab";
		String str2="ac";
		
		int ans1=smallestSuperSeqence(str1, str2, 0, 0);
		System.out.println(ans1);
		int ans=smallestSuperIte(str1, str2);
		
		System.out.println(ans);
//		int res=str1.length()+str2.length()-ans;
//		System.out.println(res);
		
	}
}
