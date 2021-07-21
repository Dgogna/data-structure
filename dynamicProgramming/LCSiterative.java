package dynamicProgramming;

public class LCSiterative {
	public static int lcs(String str1, String str2) {
		int[][] dp=new int[str1.length()+1][str2.length()+1];

		String str="";
		for(int r=0;r<dp.length;r++) {
			for(int c=0;c<dp[r].length;c++) {
				dp[r][c]=0;
			}
		}


		for(int i=str1.length()-1;i>=0;i--) {
			for(int j=str2.length()-1;j>=0;j--) {
				if(str1.charAt(i)==str2.charAt(j)) {
					dp[i][j]=1+dp[i+1][j+1];
					str+=str1.charAt(i);
				}else {
					dp[i][j]=Math.max(dp[i+1][j], dp[i][j+1]);
				}
			}
		}
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[i].length;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println(str);
		return dp[0][0];


	}

	public static void main(String[] args) {
		String str1="abcdghacdwwww";
		String str2="abedfhadwww";
		int ans=lcs(str1,str2);
		System.out.println(ans);
	}
}
