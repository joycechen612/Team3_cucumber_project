@searchBox
Feature: verify search box function
  @ui
  Scenario: 
    Given user come to Zulily homepage
    Then user enter "home" in the searchBox
    And user should verify all the drop down options contains keyword "home"
    Then user choose "Linon Home"
    And verify "Linon Home" should on the each search result
 
