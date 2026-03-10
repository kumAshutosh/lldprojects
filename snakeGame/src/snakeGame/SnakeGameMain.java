package snakeGame;

import java.util.Scanner;

import stratergy.HumanSnakeStrategy;

public class SnakeGameMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int width = 5;
		int height = 5;

		int[][] foodPosition = { { 1, 1 }, { 3, 4 }, { 0, 2 }, { 4, 4 }, { 0, 0 } };

		// Initialize the game
		SnakeGame game = new SnakeGame(width, height, foodPosition, new HumanSnakeStrategy());
		
		System.out.println("==========Start the Game===========");
		Scanner scanner=new Scanner(System.in);
		int score=0,prevScore=0;
		while(true) {
			//displayGameState(In reality it would be graphical 2d representation of the game)
			System.out.println("Enter directions now");
			String input=scanner.nextLine().toUpperCase();
			score=game.move(input);
			if(score==-1) {
				System.out.println("==========Game Over!!!!Final Score =======");
				System.out.println(prevScore);
				break;
			}
			else {
				prevScore=score;
			}
		}
		scanner.close();
		System.out.println("Thanxx for playing");
	}
}