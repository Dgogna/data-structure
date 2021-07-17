package recursion___2;
import java.util.*;
public class PrintKeyPadCode {
	
	public static void printKeyPad(int n, String str, HashMap<Integer,String> map) {
		if(n==0) {
			System.out.println(str);
			return;
		}
		
		String s=map.get(n%10);
		for(int i=0;i<s.length();i++) {
			printKeyPad(n/10,s.charAt(i)+str,map);
		}
		
		
	}
	
	public static void main(String[] args) {
		HashMap<Integer,String> my=new HashMap<>();
		my.put(2,"abc");
		my.put(3,"def");
		my.put(4, "ghi");
		my.put(5,"jkl");
		my.put(6,"mno");
		my.put(7, "pqrs");
		my.put(8,"tuv");
		my.put(9,"wxyz");
		
		printKeyPad(23,"",my);
	}
	
}
