package com.ashutosh.dice;

import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Simulator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean invalid=true;
		
		System.out.println("How many dice ou want to roll?");
		
		while (invalid) {
			try {
				int input = sc.nextInt();
				
				invalid = false;
				System.out.println("About to roll " + input + " dice");
				Random rand = new Random();

				for (int i = 0; i < input; i++) {
					int rolledNumber = (rand.nextInt(6) + 1);
					System.out.println(display(rolledNumber));
				}
			} catch (Exception InputMismatchException) {
				System.out.println("Enter valid integer value");
				sc.nextLine();
			}
		}
		sc.close();
	}

	static String display(int val) {
		switch(val) {
		case 1:return "____\n|   |\n| o |\n|   |\n____";
		
		case 2:return "____\n|o  |\n|   |\n|  o|\n____";
		
		case 3:return "____\n|o  |\n| o |\n|  o|\n____";
		
		case 4:return "____\n|oo |\n|   |\n| oo|\n____";
		
		case 5:return "____\n|o o|\n| o |\n|o o|\n____";
		
		case 6:return "____\n|ooo|\n|   |\n|ooo|\n____";
		
		default: return "wrong input";
		}
	}
}
