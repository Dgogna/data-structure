package dynamicProgramming;

import java.util.HashMap;

public class ByteLandian {

	public static long byteLandian(long n, HashMap<Long,Long> memo) {
		if(n==0 ) {
			return n;
		}
		
		long ans1;
		if(memo.get(n/2)==null) {
			ans1=byteLandian(n/2,memo);
			memo.put(n/2, ans1);
		}else {
			ans1=memo.get(n/2);
		}
		
		long ans2;
		if(memo.get(n/3)==null) {
			ans2=byteLandian(n/3,memo);
			memo.put(n/3, ans2);
		}else {
			ans2=memo.get(n/3);
		}
		
		long ans3;
		if(memo.get(n/4)==null) {
			ans3=byteLandian(n/4,memo);
			memo.put(n/4, ans3);
		}else {
			ans3=memo.get(n/4);
		}
		return Math.max(n,ans1+ans2+ans3);
	}
	
	public static long byteLandian(long n) {
		
		if(n==0 ) {
			return n;
		}
		
		long ans1=byteLandian(n/2);
		long ans2=byteLandian(n/3);
		long ans3=byteLandian(n/4);
		
		return Math.max(n,ans1+ans2+ans3);

	}
	
	public static void main(String[] args) {
		HashMap<Long,Long> my=new HashMap<>();
		long ans=byteLandian(12,my);
		System.out.println(ans);
	}
}
