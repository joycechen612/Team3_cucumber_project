@creatNewAccount
Feature: Creat New Account

  @ui
  Scenario Outline: Happy Path
    Given user navigate to KaTom homepage
    When user click on Sign in button and click on Creat Account button
    And enter self info and click Creat Account
      | First Name | Last Name | Email                   | Password  |
      | Shaoling   | stouder   | kangxuelin8888@gamil.com | Kt1234567 |
    Then the newly created account should be on the page
