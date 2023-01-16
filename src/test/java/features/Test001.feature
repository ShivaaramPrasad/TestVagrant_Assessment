Feature: Check Forgin Players from RCB Team 
  Background:
    Given Read the JSON file TeamRCB
  Scenario: TC001 Check How many Forgin Players from RCB Team
    Then Validate the team has only 4 foreign players