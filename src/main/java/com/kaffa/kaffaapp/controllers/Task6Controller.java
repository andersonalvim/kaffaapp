package com.kaffa.kaffaapp.controllers;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaffa.kaffaapp.models.Message;



@RestController
public class Task6Controller {
	
	@GetMapping(path = "/task6")
	  public Message getMessage() {
		
		String output = "";
		JSONObject obj = new JSONObject();
		
		try {
			URL url = new URL("http://worldclockapi.com/api/json/utc/now");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			if(conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP Error code : "
						+ conn.getResponseCode());
			}
			
			Scanner scanner = new Scanner(url.openStream());
			
			while (scanner.hasNext()) {
                output += scanner.nextLine();
            }
			
			scanner.close();
			
			JSONParser parse = new JSONParser();
			obj = (JSONObject) parse.parse(output);
			
			conn.disconnect();
			
			
		} catch (Exception e) {
			System.out.println("Exception in NetClientGet:- " + e);
		}
		
		
		
		String s = (String) obj.get("currentDateTime");
																					
	    final Message message = new Message();
	    message.setText("World Clock");
	    message.setDate(
	            LocalDate.parse(s.substring(0,10)));
	    message.setTime(
	            LocalTime.parse(s.substring(11,16)+":00"));
	    message.setTimestamp(
	            LocalDateTime.parse(s.replace("Z", ":")+"00"));
	    return message;
	  }
}
