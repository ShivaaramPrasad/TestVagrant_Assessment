package com.iplteam;

import java.net.MalformedURLException;
import java.util.List;


public interface IPLJsonService {
	
	/**
	 * This method used to read the JSON file 
	 * @param fileName - helps to load the team details`
	 * @return type void 
	 * @author Shivaaram
	 */	
	public void readJsonFile(String fileName);
	
	/**
	 * This method used to check how many foreign player in a team 
	 * @param foreignCount - helps to check the condition number of foreign player in a team
	 * @return type boolean  
	 * @author Shivaaram
	 */
	public boolean checkForeignPlayers(int foreignCount);
	
	/**
	 * This method used to check how many wicket keeper in a team 
	 * @param foreignCount - helps to check the condition number of wicket keeper in a team
	 * @return type boolean
	 * @author Shivaaram
	 */
	public boolean checkWicketKeeperPlayers(int wicketKeeperCount);
}
