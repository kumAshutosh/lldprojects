package chess;

public class Move {
	private Cell startCell;
	private Cell endCell;
	
	public Move(Cell startCell,Cell endCell) {
		this.endCell=endCell;
		this.startCell=startCell;
	}
	public Cell getStartCell() {
		return startCell;
	}
	public Cell getEndCell() {
		return endCell;
	}
	public boolean isValid() {
		return !(startCell.getPiece().isWhitePiece()==endCell.getPiece().isWhitePiece());
	}
}
