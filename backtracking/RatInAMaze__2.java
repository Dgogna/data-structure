package backtracking;

public class RatInAMaze__2 {
	
	public static boolean ratInMaze(int maze[][], int i, int j, int path[][]) {
		
		if(i==maze.length-1 && j==maze.length-1) {
			path[i][j]=1;
			return true;
		}
		if(i<0 || j<0 || i>=maze.length || j>=maze.length || maze[i][j]==0 || path[i][j]==1) {
			return false;
		}
		path[i][j]=1;
		
		if(ratInMaze(maze, i-1, j, path)==true) {
			return true;
		}
		if(ratInMaze(maze, i, j+1, path)==true) {
			return true;
		}
		if(ratInMaze(maze, i+1, j, path)==true) {
			return true;
		}
		if(ratInMaze(maze, i, j-1, path)==true) {
			return true;
		}
		
		return false;
		
	}

	public static void main(String[] args) {
		int maze[][]= {{1,1,0},{1,0,1},{0,1,1}};
		int path[][]=new int[maze.length][maze.length];
		boolean isPossible=ratInMaze(maze, 0,0,path);
		for(int i=0;i<maze.length;i++) {
			for(int j=0;j<maze.length;j++) {
				System.out.print(path[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(isPossible);
	}
}
