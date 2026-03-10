package com.ashutosh.passwordgenerator;

public interface UserInterface {
	public int getPasswordLength();
	public boolean useLowerCase();
	public boolean useUpperCase();
	public boolean useNumbers();
	public boolean useSpecialChar();
	public void display(String password);
}
