package chess;

public class Knight extends Piece {
	private MovementStrategy movementStrategy;

	public Knight(boolean isWhitePiece) {
		super(isWhitePiece, new knightMovementStrategy());
		// TODO Auto-generated constructor stub
	}

}
