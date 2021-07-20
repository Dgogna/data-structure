package dp___1;

public class coinTower {
	
	public static String findWinner(int n, int x, int y) {
		//Your code goes here
        int arr[]=new int[n+1];
        
        arr[1]=1;
        arr[x]=1;
        arr[y]=1;
        
        for(int i=2;i<=n;i++){
            if(arr[i]==0){
                int v1=arr[i-1];
                int v2=-1;
                int v3=-1;
                if(i-x>0){
                    v2=arr[i-x];
                }
                if(i-y>0){
                    v3=arr[i-y];
                }
                
                if(v1==1 && v2==1 && v3==1){
                    arr[i]=2;
                }else{
                    arr[i]=1;
                }
            }
        }
        
        if(arr[n]==2){
            return "Whis";
        }
        return "Beerus";
        
	}

	public static void main(String[] args) {
		
		String ans=findWinner(4, 2, 3);
		System.out.println(ans);
	}
}
