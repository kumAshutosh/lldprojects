package stratergy;

import snakeGame.Pair;

public interface SnakeStrategy {
	Pair getnextPosition(Pair currentHead, String direction);
}
