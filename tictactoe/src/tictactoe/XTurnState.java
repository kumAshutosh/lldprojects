package tictactoe;

public class XTurnState implements GameState{

	@Override
	public boolean isGameOver() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void next(GameContext context) {
		// TODO Auto-generated method stub
		if(Board.won==Symbol.x)
			context.setState(new XWonState());
		else
			context.setState(new OTurnState());
	}

}
