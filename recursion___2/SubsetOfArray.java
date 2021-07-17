package recursion___2;

public class SubsetOfArray {

	public static int[][] subsets(int arr[],int si){
		if(si==arr.length) {
			int[][] ans= new int[1][0];
			
			return ans;
		}

		
		int[][] small=subsets(arr,si+1);
		int ans[][]=new int[small.length*2][];
		
		for(int i=0;i<small.length;i++) {
			ans[i]=new int[small[i].length];
			for(int j=0;j<small[i].length;j++) {
				ans[i][j]=small[i][j];
			}
		}
		
		for(int i=0;i<small.length;i++) {
			ans[i+small.length]=new int[small[i].length+1];
			ans[i+small.length][0]=arr[si];
			for(int j=0;j<small[i].length;j++) {
				ans[i+small.length][j+1]=small[i][j];
			}
		}
		
		return ans;
		
		
	}
	
	public static void main(String[] args) {
		int arr[]= {1,2,3};
		int res[][]=subsets(arr,0);
		
		for(int i=0;i<res.length;i++) {
			for(int j=0;j<res[i].length;j++) {
				System.out.print(res[i][j]);
			}
			System.out.println();
		}
		
	}
}
