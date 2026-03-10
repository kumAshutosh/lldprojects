package com.ashutosh.weatherforecast;
import java.util.Scanner;
import java.io.IOException;

public class WeatherApp {

	public static void main(String[] args) throws IOException {
		WeatherAPI api=new WeatherAPI();
		Scanner sc=new Scanner(System.in);
		while(true) {
		System.out.println("What city would you like to get the weather report for ?");
		String city=sc.nextLine();
		weatherResponseParser parser=new weatherResponseParser();
		parser.parseAndPrint(api.getForecast(city));
		System.out.println("Press (n) to exit");
		String s=sc.nextLine();
		if(s.equals("n"))
			break;
		}
		sc.close();
	}
}
