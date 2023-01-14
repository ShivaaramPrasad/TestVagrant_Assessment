package ipl.testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.iplteam.IPLJsonServiceImpl;

public class ValidateNegativeTestCase extends IPLJsonServiceImpl {
	
	@BeforeTest
	public void preSetUp() {
		readJsonFile("TeamRCB");
	}
	
	@Test(priority=1)
	@Parameters("fpCount")
	public void testNoOfForeignPlayersInRCB(@Optional("3")int fpCount){
		Assert.assertFalse(checkForeignPlayers(fpCount));	
	}
	
	@Test(priority=0)
	@Parameters("wkCount")
	public void testNoOfWicketKeeperInRCB(@Optional("2")int wkCount){
		Assert.assertFalse(checkWicketKeeperPlayers(wkCount));
	}
	
}
