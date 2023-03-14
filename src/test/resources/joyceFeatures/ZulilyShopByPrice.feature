@shopByPrice
Feature: Verify Shop By price Function

  @ui
  Scenario: 
    Given user come to Zulily homepage
    Then user click Shop By Category on the navi bar
    Then user click Toys & Games
    Then user click ALL PRICES button check $50 - $100
    And verify all the result come out are in the range
