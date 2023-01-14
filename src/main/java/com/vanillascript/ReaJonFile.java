package com.vanillascript;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReaJonFile {

	public static void main(String[] args) {
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
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
