package com.iplteam;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class IPLJsonServiceImpl implements IPLJsonService  {

	public static JSONObject iplTeamObject;
	protected static int iplWicketKeeperCount;
	protected static int iplForeignPlayerCount;

	public void readJsonFile(String fileName) {
		try {
			JSONParser jsonparser = new JSONParser();
			FileReader fileReader = new FileReader("./src/test/resources/testdata/"+fileName+".json");
			Object object = jsonparser.parse(fileReader);
			iplTeamObject = (JSONObject) object;
		} catch(ParseException e)
		{
			System.out.println("Unable to Parse : "+e);
		} catch(IOException e)
		{
			System.out.println("File not found ! "+e);
		} catch(Exception e)
		{
			System.out.println("Exception Message : "+e);
		}
	}

	public void checkForeignPlayers(int foreignCount) {
		// TODO Auto-generated method stub
		
	}

	public void checkWicketKeeperPlayers(int wicketKeeperCount) {
		// TODO Auto-generated method stub
		
	}
	
	

}
