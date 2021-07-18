package backtracking;
import java.util.Scanner;
public class MinStepsToOne {

	public static int countMinStepsToOneIt(int n) {
		int dp[]=new int[n+1];
		if(n==1) {
			return 0;
		}
		dp[1]=0;
		for(int i=2;i<dp.length;i++) {
			int ans1=dp[i-1];
			int ans2=Integer.MAX_VALUE;
			if(i%2==0) {
				ans2=dp[i/2];
			}
			int ans3=Integer.MAX_VALUE;
			if(i%3==0) {
				ans3=dp[i/3];
			}
			System.out.println(ans1+" "+ans2+" "+ans3);
			int res=1+Math.min(ans1, Math.min(ans2, ans3));
            dp[i]=res;
		}
		for(int i:dp) {
			System.out.println(i);
		}
		return dp[n];
	}

	public static int countMinStepsToOneDp(int n, int dp[]) {
		if(n==1) {
			return 0;
		}
		int ans1;
		if(dp[n-1]==-1) {
			ans1=countMinStepsToOneDp(n-1,dp);
			dp[n-1]=ans1;
		}
		else {
			ans1=dp[n-1];
		}

		int ans2=Integer.MAX_VALUE;
		if(n%2==0) {
			if(dp[n/2]==-1) {
				ans2=countMinStepsToOneDp(n/2,dp);
				dp[n/2]=ans2;
			}
			else {
				ans2=dp[n/2];
			}
		}

		int ans3=Integer.MAX_VALUE;
		if(n%3==0) {
			if(dp[n/3]==-1) {
				ans3=countMinStepsToOneDp(n/3,dp);
				dp[n/3]=ans3;
			}
			else {
				ans3=dp[n/3];
			}
		}

		int res=1+Math.min(ans1, Math.min(ans2, ans3));
		return res;

	}

	public static int countMinStepsToOne(int n) {
		if(n==1) {
			return 0;
		}

		int ans1=countMinStepsToOne(n-1);
		int ans2=Integer.MAX_VALUE;
		if(n%2==0) {
			ans2=countMinStepsToOne(n/2); 				
		}
		int ans3=Integer.MAX_VALUE;
		if(n%3==0) {
			ans3=countMinStepsToOne(n/3);
		}

		int res=1+Math.min(ans1, Math.min(ans2, ans3));
		return res;
	}

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);

		int n=s.nextInt();

		int arr[]=new int[n+1];
		for(int i=0;i<arr.length;i++) {
			arr[i]=-1;
		}
		int ans1=countMinStepsToOne(n);
		int ans2=countMinStepsToOneDp(n,arr);
		int ans3=countMinStepsToOneIt(n);
//		for(int i=3;i<20;i++) {
//			int ans1=countMinStepsToOne(i);
//			int ans3=countMinStepsToOneIt(i);
//			System.out.println(i+"-->"+ans1+" "+i+"-->"+ans3);
//		}
		System.out.println(ans1+" "+ans3);
	}
}
