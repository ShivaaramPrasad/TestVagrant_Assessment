package ipl.testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.iplteam.IPLJsonServiceImpl;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ValidateRCBTeamWicketKeeper extends IPLJsonServiceImpl {
	
	@BeforeTest
	@Parameters("fileName")
	public void preSetUp(@Optional("TeamRCB") String fileName) {
		System.out.println("Read the Json File");
		readJsonFile(fileName);
	}
	
	@Test
	@Parameters("wkCount")
	public void testNoOfWicketKeeperInATeam(@Optional("1")int wkCount){
		System.out.println("Check Postive Testcase for Wicket Keeper");
		Assert.assertTrue(checkWicketKeeperPlayers(wkCount));
	}
	
}
