package com.ashutosh.filemanager;

import java.util.Scanner;

public class TextBasedInter implements UserInterface {

	private UIEventHandler handler = null;

	@Override
	public void start() {
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.println("Enter your choice from-->Menu for file management");
		System.out.println("1. List files");
		System.out.println("2. create directory");
		System.out.println("3. delelte file/directory");
		System.out.println("4. Exit");

		while (true) {
			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				System.out.println("Enter directory Path:");

				handler.onList(sc.nextLine());
				break;
			case 2:
				System.out.println("Enter directory Path:");

				handler.onCreate(sc.nextLine());
				break;
			case 3:
				System.out.println("Enter directory Path:");

				handler.onDelete(sc.nextLine());
				break;
			case 4:
				System.out.println("Exiting");
				sc.close();
				return;
			default:
				System.out.println("Not valid choice");
			}
		}
	}

	@Override
	public void subscribe(UIEventHandler handler) {
		// TODO Auto-generated method stub
		if(handler!=null)
			this.handler=handler;
	}

	@Override
	public void display(String message) {
		// TODO Auto-generated method stub
		System.out.println(message);
	}

}
