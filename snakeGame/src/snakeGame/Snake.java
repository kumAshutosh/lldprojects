package snakeGame;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;


public class Snake {
	private Deque<Pair> body;
	private Map<Pair,Boolean> positionMap;//for checking collision check
	
	public Snake() {
		this.body=new LinkedList<>();
		Pair initialPos=new Pair(0,0);
		this.getBody().offerFirst(initialPos);
		this.positionMap.put(initialPos, true);
	}

	public Deque<Pair> getBody() {
		return body;
	}
	public Map<Pair,Boolean> getPositionMap(){
		return positionMap;
	}

}
