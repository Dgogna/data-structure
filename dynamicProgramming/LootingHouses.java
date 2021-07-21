package dynamicProgramming;

public class LootingHouses {

	public static int maxMoneyLooted(int arr[]) {
		int dp[]=new int[arr.length];
		dp[0]=arr[0];
		dp[1]=Math.max(arr[1], arr[0]);
		for(int i=2;i<arr.length;i++) {
			dp[i]=Math.max(arr[i]+dp[i-2],dp[i-1] );
		}
		return dp[arr.length-1];
	}


	public static void main(String[] args) {
		int arr[]= {5,5,10,100,10,5};
		int ans=maxMoneyLooted(arr);
		System.out.println(ans);

	}
}
