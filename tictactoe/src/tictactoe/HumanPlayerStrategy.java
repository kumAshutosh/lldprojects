package tictactoe;

import java.util.*;

public class HumanPlayerStrategy implements PlayerStrategy{
	private String name;
	private Scanner scanner;
	
	public HumanPlayerStrategy(String name) {
		this.name=name;
		this.scanner=new Scanner(System.in);
	}

	@Override
	public Position makeMove(Board board) {
		// TODO Auto-generated method stub
		while(true) {
			System.out.println("Enter row and column numbers in range 0-2");
			try {
				int row=scanner.nextInt();
				int col=scanner.nextInt();
				
				Position move=new Position(row,col);
				if(board.isValidMove(move)) return move;
				
				System.out.println("Make a valid move");
			} catch (Exception e) {
				System.out.println("enter value as integers only");
				scanner.nextLine();
			}
		}
	}

}
