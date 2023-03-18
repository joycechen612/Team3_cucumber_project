@taglogin
Feature: Login

  #
  #@UI
  #Scenario: Happy path login
  #Given user is on the zulily homepage
  #When user navigates to the login page
  #And user enters username and password
  #| username | yipingchenmm@gmail.com |
  #| password | Chyp120917@            |
  #And user clicks on the login button
  #Then user should be see pagetext on the page
  @UI @Unhappy
  Scenario Outline: Unhappy path login
    Given user is on the zulily homepage
    When user navigates to the login page
    And user enters username and password
      | username | <username> |
      | password | <password> |
    And user clicks on the login button
    Then user should see an error alert with the message - "<errorMessage>"

    Examples: 
      | username               | password | errorMessage             |
      | yipingchenmm@gmail.com |          | Password cannot be blank |
      |                        | chyp1200 | Email cannot be blank    |
