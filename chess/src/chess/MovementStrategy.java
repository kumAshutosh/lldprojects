package chess;

public interface MovementStrategy {
	boolean canMove(Board board, Cell startCell,Cell endCell);
}
