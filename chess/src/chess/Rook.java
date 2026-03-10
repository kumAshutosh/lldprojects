package chess;

public class Rook extends Piece {
	private MovementStrategy movementStrategy;
	public Rook(boolean isWhitePiece) {
		super(isWhitePiece, new rookMovementStrategy());
		// TODO Auto-generated constructor stub
	}

}
