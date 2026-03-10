package stratergy;

import snakeGame.Pair;

public class HumanSnakeStrategy implements SnakeStrategy{

	@Override
	public Pair getnextPosition(Pair currentHead, String direction) {
		// TODO Auto-generated method stub
		int row=currentHead.getRow();
		int col=currentHead.getCol();
		
		switch(direction.toUpperCase()) {
		case "U": return new Pair(row-1,col);
		case "D": return new Pair(row+1,col);
		case "L": return new Pair(row,col-1);
		case "R": return new Pair(row,col+1);
		default: return currentHead;
		}
	}

}
