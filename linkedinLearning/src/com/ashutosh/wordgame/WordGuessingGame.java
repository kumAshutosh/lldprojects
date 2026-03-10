package com.ashutosh.wordgame;

import java.util.Random;
import java.util.Scanner;

public class WordGuessingGame {
	int attempt;
	String wordToGuess;
	private char[] guessedLetter;
	
	public WordGuessingGame(String[] wordList,int maxAttempt){
		Random rand=new Random();
		this.wordToGuess=wordList[rand.nextInt(wordList.length)];
		this.guessedLetter=new char[this.wordToGuess.length()];
		
		for(int i=0;i<this.guessedLetter.length;i++) {
			this.guessedLetter[i]='-';
		}
		this.attempt=maxAttempt;
	}
	
	public void play() {
		Scanner sc=new Scanner(System.in);
		//System.out.println("Enter your Guess:");
		while(attempt>0) {
			System.out.println("you have "+attempt+" left");
			System.out.println("Enter your Guess:");
			
			for(char let: guessedLetter)
				System.out.print(let);
			System.out.println();
			char ch=sc.nextLine().toLowerCase().charAt(0);
			if(!processGuess(ch)) {
				System.out.println("guess "+ch+" incorrect");
				attempt--;
			}
			else {
				System.out.println("guessed correctly");
				if(new String(guessedLetter).equals(wordToGuess)) {
					System.out.println("You won the game! Word was indeed"+wordToGuess);
					return;
				}
			}
		}
		System.out.println("You lost the game");
	}
	
	private boolean processGuess(char letter) {
		boolean found=false;
		
		for(int i=0;i<wordToGuess.length();i++) {
			if(wordToGuess.charAt(i)==letter) {
				guessedLetter[i]=letter;
				found=true;
			}
		}
		return found;
	}
}
