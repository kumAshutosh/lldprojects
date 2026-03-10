package chess;

public class Bishop extends Piece {
	private MovementStrategy movementStrategy;

	public Bishop(boolean isWhitePiece) {
		super(isWhitePiece, new bishopMovementStrategy());
		// TODO Auto-generated constructor stub
	}

}
