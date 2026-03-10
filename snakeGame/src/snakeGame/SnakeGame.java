package snakeGame;

import stratergy.SnakeStrategy;

public class SnakeGame {
	private GameBoard board;
	private int[][] food;
	private Snake snake;
	private int foodIndex;
	private SnakeStrategy movementStrategy;
	
	public SnakeGame(int width,int height,int[][] food,SnakeStrategy movementStrategy) {
		this.board=GameBoard.getInstance(width, height);
		this.food=food;
		this.foodIndex=0;
		this.movementStrategy=(movementStrategy);
	}

	public SnakeStrategy getMovementStrategy() {
		return movementStrategy;
	}

	public void setMovementStrategy(SnakeStrategy movementStrategy) {
		this.movementStrategy = movementStrategy;
	}
	public int move(String direction) {
		Pair currentHead=snake.getBody().peekFirst();
		Pair newHead=this.movementStrategy.getnextPosition(currentHead, direction);
		int newHeadRow=newHead.getRow();
		int newHeadCol=newHead.getCol();
		
		boolean crossBoundary=(newHeadRow<0 || newHeadRow==board.getRow() 
				||newHeadCol<0||newHeadCol==board.getCol());
		
		Pair currentTail=snake.getBody().peekLast();
	
		boolean bitesItself=this.snake.getPositionMap().containsKey(newHead) &&
				!((newHead.getCol()==currentTail.getCol())&&(newHead.getRow()==currentTail.getRow()));
		
		if(crossBoundary||bitesItself) return -1;
		boolean ateFood=this.foodIndex<this.food.length &&
				this.food[this.foodIndex][0]==newHeadRow && this.food[this.foodIndex][1]==newHeadCol;
		if(ateFood)
			this.foodIndex++;
		else {
			this.snake.getBody().pollLast();
			this.snake.getPositionMap().remove(currentTail);
		}
		
		this.snake.getBody().addFirst(newHead);
		this.snake.getPositionMap().put(newHead, true);
		
		int score=this.snake.getBody().size()-1;
		return score;
		
	}
}
