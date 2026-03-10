package chess;

import java.util.*;


public class Game {
	private Board board;
	private Player player1;
	private Player player2;
	boolean isWhiteTurn;
	private Status status;
	
	public Game(Player player1,Player player2) {
		Board.getInstance(8);
		this.player1=player1;
		this.player2=player2;
		this.status= Status.ACTIVE;
	}
	
	public void start() {
        Player currentPlayer = isWhiteTurn ? player1 : player2;
        System.out.println(currentPlayer.getName() + "'s turn (" + (currentPlayer.isWhiteSide() ? "White" : "Black") + ")");
        Scanner scanner=new Scanner(System.in);
        // Ask for source coordinates
        System.out.print("Enter source row and column (e.g., 6 4): ");
        int startRow = scanner.nextInt();
        int startCol = scanner.nextInt();

        // Ask for destination coordinates
        System.out.print("Enter destination row and column (e.g., 4 4): ");
        int endRow = scanner.nextInt();
        int endCol = scanner.nextInt();

        // Get the start and end cells from the board
        Cell startCell = board.getCell(startRow, startCol);
        Cell endCell = board.getCell(endRow, endCol);
        
        makeMove(new Move(startCell, endCell), currentPlayer);
	}

	private void makeMove(Move move, Player player) {
		// TODO Auto-generated method stub
		if(move.isValid()) {
			Piece sourcePiece=move.getStartCell().getPiece();
			
			if(sourcePiece.canMove(this.board, move.getStartCell(), move.getEndCell())) {
				
				Piece destinationPiece=move.getEndCell().getPiece();
				if(destinationPiece!=null) {
					if(destinationPiece instanceof King && isWhiteTurn) {
						status=Status.WHITEWON;
						return;
					}
					if(destinationPiece instanceof King && !isWhiteTurn) {
						status=Status.BLACKWON;
						return;
					}
					destinationPiece.setKilled(true);
				}
				
				move.getEndCell().setPiece(sourcePiece);
				move.getStartCell().setPiece(null);
				isWhiteTurn=!isWhiteTurn;
			}
		}
		
	}
}
