package recursion___2;
import java.util.*;
public class KeyPadCode {

//	public static String[] keyPad(int n,HashMap<Integer,String> map) {
//		if(n==0 || n==1) {
//			String ans[]= {""};
//			return ans;
//		}
//		int num=n/10;
//		String small[]=keyPad(num,map);
//
//		String str=map.get(n%10);
//		String ans[]=new String[str.length()*small.length];
//
//		int k=0;
//		for(int i=0;i<str.length();i++) {
//			for(int j=0;j<small.length;j++) {
//				ans[k]=small[j]+str.charAt(i);
//				k++;	
//			}
//		}
//		return ans;
//	}
	public static String helper(int n) {
		if(n==0 || n==1){
            return "";
        }
        else if(n==2){
            return "abc";
        }
        else if(n==3){
            return "def";
        }
        else if(n==4){
            return "ghi";
        }
        else if(n==5){
            return "jkl";
        }
        else if(n==6){
            return "mno";
        }
        else if(n==7){
            return "pqrs";
        }
        else if(n==8){
            return "tuv";
        }
        //else if(n==9){
            return "wxyz";
      //  }
//		char arr[]=new char[28];
//		int k=0;
//		for(int i=2;i<28;i++) {
//			arr[i]=(char) (97+k);
//			k+=3;
//		}
//		
//		String str="";
//		for(int i=0;i<3;i++) {
//			str+=(char)(arr[n]+i);
//		}

		//return str;
	}
	
	public static String[] keypad(int n) {
		if(n==0) {
			String ans[]= {""};
			return ans;
		}
		
		String small[]=keypad(n/10);
		String str=helper(n%10);
		String ans[]=new String[str.length()*small.length];
		int k=0;
		for(int i=0;i<str.length();i++) {
			for(int j=0;j<small.length;j++) {
				
				ans[k]=small[j]+str.charAt(i);
				
				k++;	
			}
		}
		return ans;
	}


	public static void main(String[] args) {
//		HashMap<Integer,String> my=new HashMap<>();
//		my.put(2,"abc");
//		my.put(3,"def");
//		my.put(4, "ghi");
//		my.put(5,"jkl");
//		my.put(6,"mno");
//		my.put(7, "pqrs");
//		my.put(8,"tuv");
//		my.put(9,"wxyz");
		

		String ans[]=keypad(23);
		for(String s:ans) {
			System.out.println(s);
		}
		
	}

}
