package tictactoe;

public class Board {
	private final int row;
	private final int col;
	private Symbol[][] grid;
	public static Symbol won=Symbol.empty;
	public static int emp;

	public Board(int row,int col) {
		this.row = row;
		this.col = col;
		emp=row*col;
		grid=new Symbol[row][col];

		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				grid[i][j]=Symbol.empty;
			}
		}
	} 
	
	public boolean isValidMove(Position pos) {
		// TODO Auto-generated method stub
		if( pos.row>=0 && pos.row<row && pos.col>=0 && pos.col<col
				&& grid[pos.row][pos.col]==Symbol.empty )
			return true;
		return false;
	}
	
	public void makeMove(Position pos, Symbol symbol) {
		grid[pos.row][pos.col]=symbol;
		emp--;
	}
	
	public void checkGameState(GameContext context) {
		//row win
		for(int i=0;i<row;i++) {
			if(grid[i][0]!=Symbol.empty && isWinningLine(grid[i])) {
				won=grid[i][0];
				context.next();
				return;
			}
		}
		//col win
		for(int i=0;i<col;i++) {
			Symbol[] column=new Symbol[row];
			for(int j=0;j<row;j++) {
				column[j]=grid[j][i];
			}
			if(column[0]!=Symbol.empty && isWinningLine(column)) {
				won=column[0];
				context.next();
				return;
			}
		}
		//dias win
	}

	private boolean isWinningLine(Symbol[] symbols) {
		// TODO Auto-generated method stub
		for(Symbol s:symbols)
			if(s!=symbols[0])
			return false;
		return true;
	}

	public void printBoard() {
		// TODO Auto-generated method stub
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
