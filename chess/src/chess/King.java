package chess;

public class King extends Piece {
	private MovementStrategy movementStrategy;
	
	public King(boolean isWhitePiece) {
		super(isWhitePiece, new kingMovementStrategy());
		// TODO Auto-generated constructor stub
	}
	
}
