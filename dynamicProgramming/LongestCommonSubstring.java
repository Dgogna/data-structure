package dynamicProgramming;

public class LongestCommonSubstring {
	
	public static int iterative(String str1,String str2) {
		int[][] dp=new int[str1.length()+1][str2.length()+1];

		int max=0;
		for(int r=0;r<dp.length;r++) {
			for(int c=0;c<dp[r].length;c++) {
				dp[r][c]=0;
			}
		}


		for(int i=str1.length()-1;i>=0;i--) {
			for(int j=str2.length()-1;j>=0;j--) {
				if(str1.charAt(i)==str2.charAt(j)) {
					dp[i][j]= 1+dp[i+1][j+1];
					if(dp[i][j]>max) {
						max=dp[i][j];
					}
				}else {
					dp[i][j]=0;
//					dp[i][j]=Math.max(dp[i+1][j], dp[i][j+1]);
				}
			}
		}
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[i].length;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		
//		System.out.println(dp[0][0]);
		return max;
	}

	public static int longestSubstring(String str1,String str2, int length) {
		if(str1.length()==0 || str2.length()==0) {
			return 0;
		}

		if(str1.charAt(0)==str2.charAt(0)) {
			length= longestSubstring(str1.substring(1), str2.substring(1),length+1);
		}


		int l1= longestSubstring(str1, str2.substring(1),0);
		int l2=longestSubstring(str1.substring(1), str2, 0);
		
		return Math.max(length, Math.max(l1, l2));

	}

	public static void main(String[] args) {

		String str1="dabc";
		String str2="acd";
		int ans=longestSubstring(str1, str2,0);
		int ans1=iterative(str1, str2);
		System.out.println(ans+" "+ans1);
	}
}
