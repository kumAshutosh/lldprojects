package com.ashutosh.wordgame;

public class App {
public static void main(String[] args) {
	String[] words= {"java","method","computer"};
	WordGuessingGame game= new WordGuessingGame(words,5);
	
	game.play();
}
}
