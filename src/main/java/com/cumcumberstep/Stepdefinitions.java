package com.cumcumberstep;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.iplteam.IPLJsonServiceImpl;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDefinitions extends IPLJsonServiceImpl {
	
	@Given("Read the JSON file (.*)$")
	public void preSetUp(String fileName) throws ParserConfigurationException {		
		readJsonFile(fileName);
	}
	
	@Then("Validate the team has only {int} foreign players")
	public void testNoOfForeignPlayersInATeam(int fpCount){
		checkForeignPlayers(fpCount);	
	}
	
	@Then("Validate there is at least {int} wicket keeper")
	public void testNoOfWicketKeeperInATeam(int wkCount){
		checkWicketKeeperPlayers(wkCount);
	}
	
	
}
