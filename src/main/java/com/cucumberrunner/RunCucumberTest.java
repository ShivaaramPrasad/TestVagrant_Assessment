package com.cucumberrunner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.github.mkolisnyk.cucumber.reporting.CucumberResultsOverview;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;


@CucumberOptions(features= {"./src/test/java/features"},
glue= {"com.cumcumberstep"}, plugin = { "json:src/test/resources/cucumber.json" }, publish = true, snippets=SnippetType.CAMELCASE)
public class RunCucumberTest extends AbstractTestNGCucumberTests {

	
	@BeforeSuite
	public static void tearUP()  throws Exception{
		System.out.println("Executing testcases by Cucumber + TestNG driven approch ");
	}
	
	@AfterSuite
	public static void tearDown()  throws Exception{
		CucumberResultsOverview results = new CucumberResultsOverview();
		results.setOutputDirectory("target");
		results.setOutputName("cucumber-results");
		results.setSourceFile("./src/test/resources/cucumber.json");
		results.executeFeaturesOverviewReport();	
	}
	
}
