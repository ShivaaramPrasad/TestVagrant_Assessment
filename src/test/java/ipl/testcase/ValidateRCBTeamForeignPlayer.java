package ipl.testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.iplteam.IPLJsonServiceImpl;

public class ValidateRCBTeamForeignPlayer extends IPLJsonServiceImpl {
	
	@BeforeTest
	public void preSetUp() {
		readJsonFile("TeamRCB");
	}
	
	@Test
	@Parameters("fpCount")
	public void testNoOfForeignPlayers(@Optional("4")int fpCount){
		Assert.assertTrue(checkForeignPlayers(fpCount));	
	}
	
}
