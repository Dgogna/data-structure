package dynamicProgramming;

public class PrintLCS {
	
	public static void printLCS(String str1,String str2,String str, int count) {
		if(str1.length()==0 || str2.length()==0) {
			if(str.length()==count) {
				System.out.println(str);
			}	
			return;
		}
		if(str1.charAt(0)==str2.charAt(0)) {
			printLCS(str1.substring(1), str2.substring(1), str+str1.charAt(0),count);
		}
		printLCS(str1.substring(1), str2, str,count);
		printLCS(str1, str2.substring(1), str,count);		
	}

	public static int countLCS(String s,String t) {
		if(s.length()==0 || t.length()==0) {
			return 0;
		}
		
		int ans;
		if(s.charAt(0)==t.charAt(0)) {
			ans=1+countLCS(s.substring(1), t.substring(1));
		}
		else {
			int ans1=countLCS(s.substring(1), t);
			int ans2=countLCS(s, t.substring(1));
			ans=Math.max(ans1, ans2);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		String str1="abcdgh";
		String str2="abedfha";
		
		int ans=countLCS(str1, str2);
		System.out.println(ans);
		printLCS(str1, str2, "", ans);
	}
}
