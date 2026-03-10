package com.ashutosh.passwordgenerator;

import java.util.Scanner;

public class TextBasedInter implements UserInterface{
	private Scanner sc;
	public TextBasedInter() {
		this.sc=new Scanner(System.in);
	}
	@Override
	public int getPasswordLength() {
		// TODO Auto-generated method stub
		System.out.println("Enter the password length you expect");
		return sc.nextInt();
	}

	@Override
	public boolean useLowerCase() {
		// TODO Auto-generated method stub
		System.out.println("Enter y/n if lowercase is required in password");
		return sc.next().equalsIgnoreCase("y");
	}

	@Override
	public boolean useUpperCase() {
		// TODO Auto-generated method stub
		System.out.println("Enter y/n if uppercase is required in password");
		return sc.next().equalsIgnoreCase("y");
	}

	@Override
	public boolean useNumbers() {
		// TODO Auto-generated method stub
		System.out.println("Enter y/n if numerical is required in password");
		return sc.next().equalsIgnoreCase("y");
	}

	@Override
	public boolean useSpecialChar() {
		// TODO Auto-generated method stub
		System.out.println("Enter y/n if special Charaters is required in password");
		return sc.next().equalsIgnoreCase("y");
	}

	@Override
	public void display(String password) {
		// TODO Auto-generated method stub
		System.out.println("Here is the password:"+ password);
	}
	
}
