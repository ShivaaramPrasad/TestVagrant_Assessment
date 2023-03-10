package ipl.testcases;

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

public class TC002 extends IPLJsonServiceImpl {
	
	@BeforeTest
	void setReportDetails() {
		testcaseName = "TC002";
		testDescription = "Validate there is at least 1 wicket keeper";
		authors = "Shivaaram";
		category = "Positive";
	}
	
	
	@Test
	@Parameters("fileName")
	public void preSetUp(@Optional("TeamRCB") String fileName) throws ParserConfigurationException {
		System.out.println(testcaseName+ " "+ testDescription);
		System.out.println("Read the Json File "+fileName+"");
		readJsonFile(fileName);
		reportLog("Read the given json file "+fileName+"","PASS");
	}
	
	@Test(dependsOnMethods = "preSetUp")
	@Parameters("wkCount")
	public void testNoOfWicketKeeperInATeam(@Optional("1")int wkCount){
		System.out.println("Check Postive Testcase for Wicket Keeper");
		Assert.assertTrue(checkWicketKeeperPlayers(wkCount));
		reportLog("Validate there is at least "+wkCount+" wicket keeper","PASS");
	}
	
}
