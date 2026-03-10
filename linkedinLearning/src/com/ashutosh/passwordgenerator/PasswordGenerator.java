package com.ashutosh.passwordgenerator;

import java.util.Random;

public class PasswordGenerator {
	String generstePassword(int length,boolean useLowerCase,boolean useUpperCase,
			boolean useNumbers,boolean useSpecialChars) {
		String lowerCase="abcdefghijklmnopqrstuvwxyz";
		String upperCase="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String numbers="0123456789";
		String specialChar="!@#$%^&*?";
		
		//String[] allString= {lowerCase,upperCase,numbers,specialChar};
		StringBuilder allString=new StringBuilder();
		if(useLowerCase)
			allString.append(lowerCase);
		if(useUpperCase)
			allString.append(upperCase);
		if(useNumbers)
			allString.append(numbers);
		if(useSpecialChars)
			allString.append(specialChar);
		
		String allChars=allString.toString();
		
		StringBuilder password=new StringBuilder();
		Random rand=new Random();
		
		for(int i=0;i<length;i++) {
			char nextLetter=allChars.charAt(rand.nextInt(allChars.length()));
			password.append(nextLetter);
		}
		
		return password.toString();
	}
}
