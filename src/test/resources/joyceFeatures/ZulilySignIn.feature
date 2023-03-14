@SignIn
Feature: Verify Zulily Sign In function

  @ui @unHappy
  Scenario Outline: use invalid username and password to try to sign in
    Given user come to Zulily homepage
    When user click Sign in button
    Then user should see a Sign In page pop out
    When user enter invalid "<email>" and "<password>"
    Then user click shop now button
    Then user should see "<errorMessage>" pop out

    Examples: 
      | email          | password | errorMessage                           |
      | test1@test.com |   123456 | Incorrect password                     |
      | name2          |   123456 | Please enter a valid email address     |
      | test1@test.com |      123 | Password must be at least 6 characters |
      |                |          | Email cannot be blank                  |
      | test1@test.com |          | Password cannot be blank               |
