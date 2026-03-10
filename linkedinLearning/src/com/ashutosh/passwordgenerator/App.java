package com.ashutosh.passwordgenerator;

public class App {
	public static void main(String[] args) {
		UserInterface input=new TextBasedInter();
		PasswordGenerator gen=new PasswordGenerator();
		
		String password=gen.generstePassword(input.getPasswordLength(),
				input.useLowerCase(), input.useUpperCase(), input.useNumbers(),input.useSpecialChar());
		
		input.display(password);
	}
}
