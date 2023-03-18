@googlesearch
Feature: Testing goolge search functionality

  @UI
  Scenario: Validate google search is working
    Given user is on google search page
    When user enters text -"zo skin health" in search box
    Then user clicks searchbutton
    Then user should see -"Shop zo skin health" search result is on the page
