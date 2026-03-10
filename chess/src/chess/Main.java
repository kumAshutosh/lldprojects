package chess;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player player1=new Player("Vishy", false);
		Player player2=new Player("Magnus", true);
		
		Game chessgame=new Game(player1, player2);
		chessgame.start();
	}

}
