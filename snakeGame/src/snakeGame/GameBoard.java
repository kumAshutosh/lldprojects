package snakeGame;

public class GameBoard {
	private static GameBoard instance;
	private int row;
	private int col;
	public int getRow() {
		return row;
	}
	private GameBoard(int row,int col) {
		this.col=col;
		this.row=row;
	}
	public static GameBoard getInstance(int row,int col) {
		if(instance==null)
			instance=new GameBoard(row,col);
		return instance;
	}
	public int getCol() {
		return col;
	}
	
}
