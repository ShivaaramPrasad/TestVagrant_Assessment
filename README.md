# TestVagrant_Assignment

<h2>Problem Statement:</h2>
<ul>
<li>1. Write test to validate that the team has only 4 foreign players</li>
<li>2. Write test to validate that their is atleast one wicket keeper </li>
 
## Software Dependencies

<table>
  <thead align="left">
    <tr border: 2 px;>
      <td><b>Dependency</b></td>
      <td><b>Version</b></td>
      <td><b>Feature</b></td>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><b>Java</b></td>
      <td><b>1.8</b></td>
      <td><b>Programming languages</b></td>
    </tr>
    <tr>
      <td><b>TestNG</b></td>
      <td><b>7.4.0</b></td>
      <td><b>Test Runner to execute suite</b></td>
    </tr>
    <tr>
      <td><b>JSON Simple</b></td>
      <td><b>1.1.1</b></td>
      <td><b>Create & Parse JSON Files for API</b></td>
    </tr>
    <tr>
      <td><b>Cucumber java</b></td>
      <td><b>3.1.5</b></td>
      <td><b>To create feature file</b></td>
    </tr>
    <tr>
      <td><b>Cucumber TestNG</b></td>
      <td><b>3.1.5</b></td>
      <td><b>Cucumber TestNG Runner to execute cucumber features</b></td>
    </tr> 
    <tr>
      <td><b>Extent Reports</b></td>
      <td><b>3.1.5</b></td>
      <td><b>The HTML reporting library</b></td>
    </tr>
  </tbody>
</table>


<h2>Project Setup </h2>
<ul>
<li>Created a Maven project added dependencies for JSon-Simple, TestNG, Cucumber, Extend Report in POM. XML</li>
<li>Folder Structure  :</li>
<li>Under src/testd/resources->testdata->added "TeamRCB" json File</li>
<li>Under src/main/java->com.iplteam->Created Interface "IPLJsonService" class</li>
<li>Under src/main/java->com.iplteam->Created implementation class for IPLJsonService  "IPLJsonServiceImpl" class</li>
<li>"IPLJsonServiceImpl" class has reusable methods listed below:</li>
	<ul>
	<li>readJsonFile(String fileName)  - Read the JSON file,parse and get JSONObject</li>
	<li>checkForeignPlayers(int foreignCount) - Checks how many Foreign Players from JSON Array</li>
    <li>checkWicketKeeperPlayers(int wicketKeeperCount) - Checks how many Wicket Keeper from JSON Array</li>
	</ul>
	
<h2>Brute Force Approach</h2>
<li>Under src/main/java->"com.vanillascript" package-> has "ReadRCBJsonFile" class </li>
<li>"ReadRCBJsonFile" class has step by step approach in reading the Json file and validating how many foreign players and wicketkeeper :</li>
	
<h2>TestNG Execution</h2>
<li>Under src/test/java->"ipl.testcases" package-> has testcases based on testNG execution class</li>
<li>"TC001"Positive Test Case - To Validate the team has only 4 foreign players:</li>
<li>"TC002"Positive Test Case - To Validate there is at least 1 wicket keeper:</li>
<li>"TC003"Negative Test Case - Check the Negative input for RCB Team :</li>
<li>testng.xml --> contains parameter will  pass the foreignplayer  and wicketkeeper method to check count</li>
<li>Report-->/test-output/emailable-report.html</li>


<h2>Cucumber Execution</h2>
<li>Under src/main/java->"com.cumcumberstep" package-> Created "StepDefinitions" for each action</li>
<li>Under src/main/java->"com.cucumberrunner" package-> Created "RunCucumberTest" for running each feature</li>
<li>Under src/test/java->"features" package-> has testcases created as a feature file using gherkin language</li>

<li>"Test001"Positive Test Case - To Validate the team has only 4 foreign players:</li>
<li>"Test002"Positive Test Case - To Validate there is at least 1 wicket keeper:</li>
<li>"Test003"Negative Test Case - Check the Negative input for RCB Team :</li>
<li>Report-->/target/cucumber-results-feature-overview.html</li>
</ul> 




