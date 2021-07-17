package recursion___2;

public class AllSubsequencce {
	
	public static String[] subsequences(String str) {
		if(str.length()==0) {
			String ans[]= {""};
			
			return ans;
		}
		String temp[]=subsequences(str.substring(1));
		
		String ans[]=new String[2*temp.length]; 
		for(int i=0;i<temp.length;i++) {
			ans[i]=temp[i];
			ans[i+temp.length]=str.charAt(0)+temp[i];
		}
//		for(int i=0;i<temp.length;i++) {
//			ans[i+temp.length]=str.charAt(0)+temp[i];
//		}
		return ans;
	}
	
	public static void main(String[] args) {
		String ans[]=subsequences("xyz");
//		for(int i=0;i<ans.length;i++) {
//			System.out.println(ans[i]);
//		}
		for(String str:ans) {
			System.out.println(str);
		}
	}
	
}
