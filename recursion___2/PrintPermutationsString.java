package recursion___2;

public class PrintPermutationsString {

	public static void permutations(String str,String res) {
		if(str.length()==0) {
			System.out.println(res);
			return;
		}
		
		for(int i=0;i<str.length();i++) {
			String small=str.substring(0,i)+str.substring(i+1);
			permutations(small,res+str.charAt(i));
		}
	}
	
	public static void main(String[] args) {
		permutations("abc","");
	}
	
}
