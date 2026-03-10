package chess;

public class Board {
	public static Board instance;
	private Cell[][] board;
	
	//private to prevent initialization
	private Board(int rows) {
		initialize(rows);
	}
	
	public static Board getInstance(int rows) {
		if(instance == null)
				instance=new Board(rows);
		return instance;
	}
	private void initialize(int rows) {
		// TODO Auto-generated method stub
		board=new Cell[rows][rows];
		
		setPieceRow(0,true);
		setPawnRow(1,rows,true);

		setPieceRow(rows-2,false);
		setPawnRow(rows-1,rows,false);
	}

	private void setPawnRow(int row, int rows, boolean isWhitePiece) {
		// TODO Auto-generated method stub
		for(int j=0;j<rows;j++) {
			board[row][j]=new Cell(row, j, PieceFactory.createPiece("pawn", isWhitePiece));
		}
	}

	private void setPieceRow(int row, boolean isWhitePiece) {
		// TODO Auto-generated method stub
		board[row][0]=new Cell(row,0,PieceFactory.createPiece("rook", isWhitePiece));
		board[row][1]=new Cell(row,1,PieceFactory.createPiece("knight", isWhitePiece));
		board[row][2]=new Cell(row,2,PieceFactory.createPiece("bishop", isWhitePiece));
		board[row][3]=new Cell(row,3,PieceFactory.createPiece("queen", isWhitePiece));
		board[row][4]=new Cell(row,4,PieceFactory.createPiece("king", isWhitePiece));
		board[row][5]=new Cell(row,5,PieceFactory.createPiece("bishop", isWhitePiece));
		board[row][6]=new Cell(row,6,PieceFactory.createPiece("knight", isWhitePiece));
		board[row][7]=new Cell(row,7,PieceFactory.createPiece("rook", isWhitePiece));
		
	}

	public Cell getCell(int startRow, int startCol) {
		// TODO Auto-generated method stub
		return board[startRow][startCol];
	}
	
}
