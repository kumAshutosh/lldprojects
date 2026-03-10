package chess;

public class Pawn extends Piece {
	private MovementStrategy movementStrategy;
	public Pawn(boolean isWhitePiece) {
		super(isWhitePiece, new pawnMovementStrategy());
		// TODO Auto-generated constructor stub
	}

}
