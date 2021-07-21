package dynamicProgramming;

public class PrintLCSIteratively {

	public static void printLCS(String str1,String str2) {
		int n=str1.length();
		int m=str2.length();
		int dp[][]=new int[n+1][m+1];
		String str="";
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(str1.charAt(i-1)==str2.charAt(j-1)) {
					dp[i][j]=1+dp[i-1][j-1];
//					str+=str1.charAt(i-1);
				}else {
					int ans1=dp[i-1][j];
					int ans2=dp[i][j-1];
					
					dp[i][j]=Math.max(ans1, ans2);
				}
			}
		}
		int i=n;
		int j=m;
		while(i>0 && j>0) {
			if(str1.charAt(i-1)==str2.charAt(j-1)) {
				str+=str1.charAt(i-1);
				i--;
				j--;
			}else {
				if(dp[i][j-1]>dp[i-1][j]) {
					j--;
				}else {
					i--;
				}
			}
		}
		
//		for(int i=0;i<dp.length;i++) {
//			for(int j=0;j<dp[i].length;j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}

		int b=str.length()-1;
		String res="";
		while(b>=0) {
			res+=str.charAt(b);
			b--;
		}
		System.out.println(res);
	}
	
	public static void main(String[] args) {
		String str1="abcdghwww";
		String str2="abedfhawwww";
		printLCS(str1, str2);
	}
}
