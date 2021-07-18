package backtracking;

public class NQueensPrint {
	
	public static boolean isSafe(int row,int col,int board[][]) {
		int n=board.length;
		for(int i=0;i<n;i++) {
			if(board[i][col]==1 || board[row][i]==1) {
				return false;
			}
		}
		// now check for the diagonal elements
		int i1=row;
		int i2=col;
		while(i1>=0 && i1<n && i2>=0 && i2<n) {
			if(board[i1][i2]==1) {
				return false;
			}
			i1--;
			i2--;
		}
		i1=row;
		i2=col;
		while(i1>=0 && i1<n && i2>=0 && i2<n) {
			if(board[i1][i2]==1) {
				return false;
			}
			i1--;
			i2++;
		}
		return true;
		
	}
	

	
	public static void placeNQueens(int n, int row, int board[][]) {
		if(row==n) {
			for(int r=0;r<n;r++) {
				for(int c=0;c<n;c++) {
					System.out.print(board[r][c]+" ");
				}
				System.out.println();	
			}
			System.out.println();
			
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(isSafe(row,i,board)) {
				board[row][i]=1;
				
				placeNQueens(n,row+1,board);
					
				board[row][i]=0;
			}
		}
		
	}

	public static void placeNQueens(int n) {
		int board[][]=new int[n][n];
		placeNQueens(n,0,board);
	}
	
	public static void main(String[] args) {
		placeNQueens(4);
	}
}
