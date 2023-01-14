package com.iplteam;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class IPLJsonServiceImpl implements IPLJsonService  {

	public  JSONObject iplTeamObject;
	protected int iplWicketKeeperCount;
	protected int iplForeignPlayerCount;

	public void readJsonFile(String fileName) {
		try {
			JSONParser jsonparser = new JSONParser();
			FileReader fileReader = new FileReader("./src/test/resources/testdata/"+fileName+".json");
			Object object = jsonparser.parse(fileReader);
			iplTeamObject = (JSONObject) object;
		} catch(ParseException e){
			System.out.println("Unable to Parse : "+e);
		} catch(IOException e){
			System.out.println("File not found ! "+e);
		} catch(Exception e){
			System.out.println("Exception Message : "+e);
		}
	}

	public boolean checkForeignPlayers(int foreignCount) {
		try
		{
			if(iplTeamObject!=null) {
				JSONArray playerArr = (JSONArray) iplTeamObject.get("player");
				for(int i=0;i<playerArr.size();i++) { 
					JSONObject player=(JSONObject)playerArr.get(i);
					String playersCountry = (String)player.get("country");
					if(!playersCountry.equals("India")) iplForeignPlayerCount++;
				}
				if(iplForeignPlayerCount==foreignCount) {
					System.out.println("Number of Foreign Player: "+iplForeignPlayerCount);
					return true;
				}else {
					System.out.println("Number of Foreign Player is not matching and its: "+iplForeignPlayerCount);
				}
			}else{
				System.out.println("Unable to fetch data from input json file");
			}
		} catch(Exception e){
			System.out.println("Exception Message : "+e);
		}
		return false;	
	}

	public boolean checkWicketKeeperPlayers(int wicketKeeperCount) {
		try
		{
			if(iplTeamObject!=null) {
				JSONArray playerArr = (JSONArray) iplTeamObject.get("player");
				for(int i=0;i<playerArr.size();i++) { 
					JSONObject player=(JSONObject)playerArr.get(i);
					String playersRole=(String)player.get("role");
					if(playersRole.equals("Wicket-keeper")) iplWicketKeeperCount++;			
				}
				if(iplWicketKeeperCount==wicketKeeperCount) {
					System.out.println("Number of Wicket Keeper: "+iplWicketKeeperCount);
					return true;
				}else {
					System.out.println("Number of Wicket Keeper is not matching and its: "+iplWicketKeeperCount);
				}
			}else {
				System.out.println("Unable to fetch data from input json file");
			}
		} catch(Exception e){
			System.out.println("Exception Message : "+e);
		}
		return false;
	}		
	

}
