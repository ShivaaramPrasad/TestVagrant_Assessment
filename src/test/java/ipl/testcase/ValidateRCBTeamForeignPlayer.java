package ipl.testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.iplteam.IPLJsonServiceImpl;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ValidateRCBTeamForeignPlayer extends IPLJsonServiceImpl {
	
	@BeforeTest
	@Parameters("fileName")
	public void preSetUp(@Optional("TeamRCB") String fileName) {
		System.out.println("Read the Json File");
		readJsonFile(fileName);
	}
	
	@Test
	@Parameters("fpCount")
	public void testNoOfForeignPlayersInATeam(@Optional("4")int fpCount){
		System.out.println("Check Postive Testcase for Foreign Players");
		Assert.assertTrue(checkForeignPlayers(fpCount));	
	}
		
}
