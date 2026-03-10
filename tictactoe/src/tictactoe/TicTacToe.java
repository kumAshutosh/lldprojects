package tictactoe;

public class TicTacToe implements BoardGames{

	private Board board;
	private Player playerX,playerO, currentPlayer;
	private GameContext gameContext;
	
	public TicTacToe(PlayerStrategy xStrategy, PlayerStrategy yStrategy, int row, int col) {
		board = new Board(row, col);
		playerX = new Player(Symbol.x, xStrategy);
		playerO = new Player(Symbol.o, yStrategy);
		currentPlayer = playerX;
		gameContext = new GameContext();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlayerStrategy playerXStrategy=new HumanPlayerStrategy("X player");
		PlayerStrategy playerOStrategy=new HumanPlayerStrategy("O player");
		
		TicTacToe game=new TicTacToe(playerXStrategy,playerOStrategy,3,3);
		game.play();
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		do {
			board.printBoard();
			
			Position move=currentPlayer.makeMove(board);
			board.makeMove(move, currentPlayer.getSymbol());
			
			board.checkGameState(gameContext);
			switchPlayer();
		} while ((!gameContext.isGameOver()) && (Board.emp!=0));
		
		finalResult();
	}
	private void finalResult() {
		// TODO Auto-generated method stub
		GameState state=gameContext.getCurrentState();
		
		if(state instanceof OWonState) {
			System.out.println("O wins the match");
		}else if(state instanceof XWonState){
			System.out.println("X wins the match");
		}else {
			System.out.println("No winner");
		}
	}
	private void switchPlayer() {
		// TODO Auto-generated method stub
		currentPlayer=(currentPlayer==playerX)?playerO:playerX;
	}

}
