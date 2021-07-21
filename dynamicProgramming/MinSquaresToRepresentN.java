package dynamicProgramming;

import java.util.Scanner;

public class MinSquaresToRepresentN {

	public static int countMin(int n) {
		if(n==0) {
			return 0;
		}
		int dp[]=new int[n+1];
		dp[0]=0;
		for(int i=1;i<dp.length;i++) {
			int temp=Integer.MAX_VALUE;
			int k=1;
			while(k*k<=i) {
               // k=n-
				if(dp[i-k*k]<temp) {
					temp=dp[i-k*k];
				}
				k++;
				//k=k-i*i;
			}
			dp[i]=1+temp;
		}

		for(int i:dp) {
			System.out.print(i+" ");
		}
		System.out.println();
		return dp[n];

	}

	public static int MinCount(int n,int arr[]) {
		if(n==0) {
			return 0;
		}
		int count=Integer.MAX_VALUE;
		for(int i=1;i*i<=n;i++) {

			int currAns;
			if(arr[n-i*i]==-1) {
				currAns=MinCount(n-i*i,arr);

				arr[n-i*i]=currAns;
			}
			else {
				currAns=arr[n-(i*i)];
			}
			if(currAns<count) {
				count=currAns;
			}
		}
		return count+1;
	}

	public static int MinCount(int n) {
		if(n==0) {
			return 0;
		}

		int count=Integer.MAX_VALUE;
		for(int i=1;i*i<=n;i++) {
			int temp=MinCount(n-i*i);
			if(temp<count) {
				count=temp;
			}
		}
		return count+1;
	}

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
//		int ans=MinCount(n);
//		System.out.println(ans);
//		int arr[]=new int[n+1];
//		for(int i=0;i<arr.length;i++) {
//			arr[i]=-1;
//		}
//		for(int i=0;i<=5;i++) {
//			int res=MinCount(i,arr);
//
//			System.out.println(res);
//		}
		int ans=countMin(n);
		System.out.println(ans);

	}
}
