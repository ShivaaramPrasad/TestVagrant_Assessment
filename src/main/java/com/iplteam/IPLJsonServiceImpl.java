package com.iplteam;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import javax.xml.parsers.ParserConfigurationException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.report.ExtentReport;


public class IPLJsonServiceImpl extends ExtentReport  implements IPLJsonService {

	public  JSONObject iplTeamObject;
	protected int iplWicketKeeperCount;
	protected int iplForeignPlayerCount;
	
	public void readJsonFile(String fileName) throws ParserConfigurationException {
		try {
			JSONParser jsonparser = new JSONParser();
			FileReader fileReader = new FileReader("./src/test/resources/testdata/"+fileName+".json");
			Object object = jsonparser.parse(fileReader);
			iplTeamObject = (JSONObject) object;
		} catch(ParseException e){
			throw new ParserConfigurationException("Unable to Parse : " +e);
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
					JSONObject iplPlayers=(JSONObject)playerArr.get(i);
					String iplPlayersCountry = (String)iplPlayers.get("country");
					if(!iplPlayersCountry.equals("India")) iplForeignPlayerCount++;
				}
				if(iplForeignPlayerCount==foreignCount) {
					System.out.println("Number of Foreign Player: "+foreignCount);
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
					JSONObject iplPlayers=(JSONObject)playerArr.get(i);
					String iplPlayersRole=(String)iplPlayers.get("role");
					if(iplPlayersRole.equals("Wicket-keeper")) iplWicketKeeperCount++;			
				}
				if(iplWicketKeeperCount==wicketKeeperCount) {
					System.out.println("Number of Wicket Keeper: "+wicketKeeperCount);
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
