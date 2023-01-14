package com.vanillascript;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReaJonFile {

	public static void main(String[] args) {
		int wicketKeeperCount=0;
		int foreignPlayerCount = 0;
		JSONParser jsonparser = new JSONParser();
		try {
			FileReader reader = new FileReader("./src/test/resources/testdata/TeamRCB.json");
			Object obj=jsonparser.parse(reader);
			JSONObject jsonObject = (JSONObject)obj;
			String teamName = (String)jsonObject.get("name");
			String location = (String)jsonObject.get("location");
			JSONArray array = (JSONArray)jsonObject.get("player");
			System.out.println("Team Name: " + teamName);
			System.out.println("Location: " + location);
			System.out.println("Players Information");
			for (int i = 0; i < array.size(); i++) {
				JSONObject player = (JSONObject)array.get(i);
				String playersName = (String)player.get("name");
				String playersCountry = (String)player.get("country");
				String playersRole = (String)player.get("role");
				String playersPrice = (String)player.get("price-in-crores");
				System.out.println(i+1+" Player Name: "+playersName);
				System.out.println("   Player Country: "+playersCountry);
				System.out.println("   Player Role: "+playersRole);
				System.out.println("   Player Price: "+playersPrice);
				if(!playersCountry.equals("India")) foreignPlayerCount++;
				if(playersRole.equals("Wicket-keeper")) wicketKeeperCount++;
			}	
			System.out.println("Number of Foreign Player: "+foreignPlayerCount);
			System.out.println("Number of Wicket Keeper: "+wicketKeeperCount);

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
