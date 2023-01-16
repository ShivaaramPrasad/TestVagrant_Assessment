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

public class TC002 extends IPLJsonServiceImpl {
	
	@BeforeTest
	void setReportDetails() {
		testcaseName = "TC002";
		testDescription = "Validate there is at least 1 wicket keeper";
		authors = "Shivaaram";
		category = "Postive";
	}
	
	
	@Test
	@Parameters("fileName")
	public void preSetUp(@Optional("TeamRCB") String fileName) throws ParserConfigurationException {
		System.out.println("Read the Json File "+fileName+"");
		readJsonFile(fileName);
		//log(Status.INFO, "Read the given json file "+fileName+"");

	}
	
	@Test(dependsOnMethods = "preSetUp")
	@Parameters("wkCount")
	public void testNoOfWicketKeeperInATeam(@Optional("1")int wkCount){
		System.out.println("Check Postive Testcase for Wicket Keeper");
		Assert.assertTrue(checkWicketKeeperPlayers(wkCount));
		//log(Status.INFO, "Validate there is at least "+wkCount+" wicket keeper");

	}
	
}
