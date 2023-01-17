package ipl.testcase;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.iplteam.IPLJsonServiceImpl;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TC003 extends IPLJsonServiceImpl {
	@BeforeTest
	void setReportDetails() {
		testcaseName = "TC003";
		testDescription = "Invalid data to check Forgin palyers and wicket keeper of given file";
		authors = "Shivaaram";
		category = "Negative";
	}

	@Test()
	@Parameters("fileName")
	public void preSetUp(@Optional("TeamRCB") String fileName) throws ParserConfigurationException {
		System.out.println("Read the Json File "+fileName+"");
		readJsonFile(fileName);
		reportLog("Read the given json file "+fileName+"","PASS");

	}
	
	@Test(dependsOnMethods = "preSetUp")
	@Parameters("fpCount")
	public void testNoOfForeignPlayersInATeam(@Optional("3")int fpCount){
		System.out.println("Check Negative Testcase for Foreign Players");
		Assert.assertFalse(checkForeignPlayers(fpCount));	
		reportLog("Validate the team has only "+fpCount+" foreign players","PASS");

	}
	
	@Test(dependsOnMethods = "preSetUp")
	@Parameters("wkCount")
	public void testNoOfWicketKeeperInATeam(@Optional("2")int wkCount){
		System.out.println("Check Negative Testcase for Wicket Keeper");
		Assert.assertFalse(checkWicketKeeperPlayers(wkCount));
		reportLog("Validate there is at least "+wkCount+" wicket keeper","PASS");

	}
	
	
}
 