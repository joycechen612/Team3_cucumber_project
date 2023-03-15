@GiftCard
Feature: 

  @ui
  Scenario: 
    Given user login zulily account
      | username | joycechen612@gmail.com |
      | password | Qwert12345!            |
    Then user click Send a Gift Card
    And gift card page should be load
    Then user click customize button under birthday
    Then user fill in the information for the gift card and click add to basket button
      | amount | send date  | recipient name | recipient email   | from | message                        |
      |     25 | 05/12/2023 | joyce          | joyce123@test.com | tina | Happy Brithday, my dear friend |
    Then verify the gift card info in the shopping basket page
