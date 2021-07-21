package dynamicProgramming;

public class MinCostPath {
	
	public static int minCostPath(int arr[][], int i, int j) {
		// special case for the last index
		if(i==arr.length-1 && j==arr.length-1) {
			return arr[i][j];
		}
		// base case
		if(i>=arr.length || j>=arr.length) {
			return Integer.MAX_VALUE;
		}
		
		int cost1=minCostPath(arr, i, j+1);
		int cost2=minCostPath(arr, i+1, j+1);
		int cost3=minCostPath(arr, i+1, j);
		
		int min=Math.min(cost1, Math.min(cost2, cost3));

		return min+arr[i][j];
		
	}
	
	public static void main(String[] args) {
		int arr[][]= {{1,5,11},{8,13,12},{2,3,7}};
		int ans=minCostPath(arr, 0, 0);
		System.out.println(ans);

	}

}
