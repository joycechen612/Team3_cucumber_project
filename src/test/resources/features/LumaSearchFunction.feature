@Luma
Feature: Search button function
  @ui
  Scenario: Happy Path 
  Given Navigate to Luma Homepage
  Then user Enter search information "top" 	
  And click the search button	
  Then the search reasult "top" should be on the page
  