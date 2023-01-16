Feature: Check Negative input for how may Check Forgin Players and wicket keeper from RCB Team 
   Background:
    Given Read the JSON file TeamRCB
   Scenario: TC003 Check the Negative input for RCB Team 
	 Then Validate the team has only 3 foreign players
     Then Validate there is at least 2 wicket keeper