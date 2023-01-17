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

public class TC001 extends IPLJsonServiceImpl {

	@BeforeTest
	void setReportDetails() {
		testcaseName = "TC001";
		testDescription = "Validate the team has only 4 foreign players";
		authors = "Shivaaram";
		category = "Postive";
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
	@Parameters("fpCount")
	public void testNoOfForeignPlayersInATeam(@Optional("4")int fpCount){
		System.out.println("Check Postive Testcase for Foreign Players");
		Assert.assertTrue(checkForeignPlayers(fpCount));	
		reportLog("Validate the team has only "+fpCount+" foreign players","PASS");
	}

}
