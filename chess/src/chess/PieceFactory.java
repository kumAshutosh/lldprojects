package chess;

public abstract class PieceFactory {
	public static Piece createPiece(String PieceType, boolean isWhitePiece) {
		switch(PieceType.toLowerCase()) {
		case "king":
			return new King(isWhitePiece);
		case "queen":
			return new Queen(isWhitePiece);		
		case "pawn":
			return new Pawn(isWhitePiece);		
		case "bishop":
			return new Bishop(isWhitePiece);
		case "rook":
			return new Rook(isWhitePiece);
		case "knight":
			return new Knight(isWhitePiece);
		default :
			throw new IllegalArgumentException("Unknown piece"+PieceType);
		}
	}
}
