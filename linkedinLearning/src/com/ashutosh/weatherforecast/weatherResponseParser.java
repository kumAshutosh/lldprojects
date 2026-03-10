package com.ashutosh.weatherforecast;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;
import org.json.JSONArray;
public class weatherResponseParser {

	public void parseAndPrint(String jsonResponse) {
		JSONObject jsonObect=new JSONObject(jsonResponse);
		if(jsonObect.getInt("cod")==200){
			System.out.println("Weather forecast for the city: ");
			JSONArray forecasts= jsonObect.getJSONArray("list");
			for(int i=0;i<forecasts.length();i++) {
				JSONObject forecast=forecasts.getJSONObject(i);
				
				long timestamp=forecast.getLong("dt");
				String date=new SimpleDateFormat("yyyy-MM-dd").format(new Date(timestamp*1000));
				
				double temperature=forecast.getJSONObject("main").getDouble("temp");
				String description=forecast.getJSONArray("weather").getJSONObject(0).getString("description");
				
				System.out.println(date +";\n Temp:"+ temperature+"deg C\n Description:"+description);
			}
		}
		else {
			System.out.println("something is wrong");
		}
	}
}
