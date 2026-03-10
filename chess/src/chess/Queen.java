package chess;

public class Queen extends Piece {
	private MovementStrategy movementStrategy;
	public Queen(boolean isWhitePiece) {
		super(isWhitePiece,new queenMovementstrategy());
		// TODO Auto-generated constructor stub
	}

}
