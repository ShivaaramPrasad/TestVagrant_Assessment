package ipl.testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.iplteam.IPLJsonServiceImpl;

public class ValidateRCBTeamWicketKeeper extends IPLJsonServiceImpl {
	
	@BeforeTest
	public void preSetUp() {
		readJsonFile("TeamRCB");
	}
	
	@Test
	@Parameters("wkCount")
	public void testNoOfWicketKeeper(@Optional("1")int wkCount)
	{
		Assert.assertTrue(checkWicketKeeperPlayers(wkCount));
	}
		
}
