package dynamicProgramming;

public class LCS {
	
	public static String print(String str1,String str2,String str) {
		if(str1.length()==0 || str2.length()==0) {
			//System.out.println(str);
			return str;
		}
		if(str1.charAt(0)==str2.charAt(0)) {
			return print(str1.substring(1), str2.substring(1), str+str1.charAt(0));
		}
		String s1=print(str1.substring(1), str2, str);
		String s2=print(str1, str2.substring(1), str);
		
		if(s1.length()>s2.length()) {
			return s1;
		}
		return s2;
//		return Math.max(str.length(), Math.max(s1.length(), s2.length()));
	}

	public static int largestCommonSubseq(String s, String t) {
		
		if(s.length()==0 || t.length()==0) {
			return 0;
		}
		
		int ans;
		if(s.charAt(0)==t.charAt(0)) {
			ans=1+largestCommonSubseq(s.substring(1), t.substring(1));
		}
		else {
			int ans1=largestCommonSubseq(s.substring(1), t);
			int ans2=largestCommonSubseq(s, t.substring(1));
			ans=Math.max(ans1, ans2);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		String str1="abcdgh";
		String str2="abedfha";
		
		int ans=largestCommonSubseq(str1, str2);
		String ans1=print(str1, str2, "");
		System.out.println(ans+" "+ans1);
		//print(str1, str2, "");
	}
}
