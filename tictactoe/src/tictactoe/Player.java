package tictactoe;

public class Player {
	private Symbol symbol;
	private PlayerStrategy strategy;

	public Player(Symbol symbol, PlayerStrategy strategy) {
		// TODO Auto-generated constructor stub
		this.symbol = symbol;
		this.strategy = strategy;
	}

	public Position makeMove(Board board) {
		// TODO Auto-generated method stub
		return strategy.makeMove(board);
	}

	public Symbol getSymbol() {
		// TODO Auto-generated method stub
		return symbol;
	}

}
