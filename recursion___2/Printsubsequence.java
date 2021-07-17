package recursion___2;

public class Printsubsequence {
	
	public static void printSubsequeunce(String s,String str) {
		if(s.length()==0) {
			System.out.println(str);
			return;
		}
		char temp=s.charAt(0);
		printSubsequeunce(s.substring(1),str);
		printSubsequeunce(s.substring(1),str+temp);
		
		
	}
	
	public static void main(String[] args) {
		printSubsequeunce("abc","");
	}
	
}
