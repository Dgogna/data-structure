package backtracking;

public class PrintAllRatMazePaths {
	
	public static void ratInAMaze(int maze[][], int n, int i ,int j, int[][] path) {
		if(i<0 || i>=n || j<0 || j>=n || maze[i][j]==0 || path[i][j]==1) {
			return;
		}
		
		path[i][j]=1;
		// here we have reached the destination
		if(i==n-1 && j==n-1) {
			// here we will print the matrix
			for(int r=0;r<n;r++) {
				for(int c=0;c<n;c++) {
					System.out.print(path[r][c]+" ");
				}
				System.out.println();
			}
			System.out.println();
			path[i][j]=0;
			return;
		}
		
		ratInAMaze(maze, n,i-1,j,path);
		ratInAMaze(maze, n,i,j+1,path);
		ratInAMaze(maze, n,i+1,j,path);
		ratInAMaze(maze, n,i,j-1,path);

		//System.out.println(i+" "+j+"\n");
		path[i][j]=0;
		
		
	}
	
	public static void ratInAMaze(int[][] maze, int n) {
		int path[][]=new int[n][n];
		ratInAMaze(maze,n,0,0,path);
	}
	
	public static void main(String[] args) {
		int arr[][]= {{1,1,0},{1,1,0},{1,1,1}};
		ratInAMaze(arr,arr.length);
	}

}
