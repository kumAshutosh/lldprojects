package tictactoe;

public interface GameState {
	boolean isGameOver();
	void next(GameContext context);
}
