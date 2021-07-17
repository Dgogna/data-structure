package recursion___2;

public class ReturnPermutations {
	
	private static int fact(int n) {
		if(n==0 || n==1) {
			return 1;
		}
		return n*fact(n-1);
	}
	
	public static String[] permutationOfString(String str) {
		if(str.length()==0) {
			String s[]= {""};
			return s;
		}
		
		String arr[]=new String[fact(str.length())];
		int k=0;
		for(int i=0;i<str.length();i++) {
			String small[]=permutationOfString(str.substring(0,i)+str.substring(i+1));
			for(int j=0;j<small.length;j++) {
				arr[k]=str.charAt(i)+small[j];
				k++;
			}
		}
		return arr;
	}
	
	public static void main(String[] args) {
		String str[]=permutationOfString("abc");
		for(String s:str) {
			System.out.println(s);
		}
	}
	
}
