package recursion___2;

public class subsetsSumToK {
	
	public static int[][] subsetsSumK(int arr[], int k, int si){
		if(si==arr.length) {
			if(k==0) {
				return new int[1][0];
			}else {
				return new int[0][0];
			}
			
		}
		int temp1[][]=subsetsSumK(arr,k-arr[si],si+1);
		int temp2[][]=subsetsSumK(arr,k,si+1);
		
		int ans[][]=new int[temp1.length+temp2.length][];
		
		for(int i=0;i<temp1.length;i++) {
			ans[i]=new int[temp1[i].length+1];
			ans[i][0]=arr[si];
			for(int j=0;j<temp1[i].length;j++) {
				ans[i][j+1]=temp1[i][j];
			}
		}
		
		for(int i=0;i<temp2.length;i++) {
			ans[i+temp1.length]=new int[temp2[i].length];
			for(int j=0;j<temp2[i].length;j++) {
				ans[i+temp1.length][j]=temp2[i][j];
			}
		}
		
		return ans;
	}
	
	public static int[][] subsetsSumK(int arr[], int k){
		int[][] res=subsetsSumK(arr,k,0);
		return res;
	}
	
	public static void main(String[] args) {
		
		int arr1[]= {3,2,1,2};
		int[][] arr=subsetsSumK(arr1,4);
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
}
