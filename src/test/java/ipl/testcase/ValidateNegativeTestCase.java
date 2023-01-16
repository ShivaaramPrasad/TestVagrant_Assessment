package ipl.testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.iplteam.IPLJsonServiceImpl;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ValidateNegativeTestCase extends IPLJsonServiceImpl {
	
	@BeforeTest
	@Parameters("fileName")
	public void preSetUp(@Optional("TeamRCB") String fileName) {
		System.out.println("Read the Json File");
		readJsonFile(fileName);
	}
	
	@Test(priority=1)
	@Parameters("fpCount")
	public void testNoOfForeignPlayersInATeam(@Optional("3")int fpCount){
		System.out.println("Check Negative Testcase for Foreign Players");
		Assert.assertFalse(checkForeignPlayers(fpCount));	
	}
	
	@Test(priority=0)
	@Parameters("wkCount")
	public void testNoOfWicketKeeperInATeam(@Optional("2")int wkCount){
		System.out.println("Check Negative Testcase for Wicket Keeper");
		Assert.assertFalse(checkWicketKeeperPlayers(wkCount));
	}
	
	
}
 