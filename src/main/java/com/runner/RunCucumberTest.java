package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(features= {"./src/test/java/features"},
glue= {"com.cumcumberstep"}, publish = true, snippets=SnippetType.CAMELCASE)

public class RunCucumberTest extends AbstractTestNGCucumberTests {

	}

 