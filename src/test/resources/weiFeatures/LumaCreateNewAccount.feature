@LumaCreateAccount
Feature: Create New Account Funtion

  @UI
  Scenario: Happy path
    Given Navigate to Luma Homepage
    And click creat an account button
    When enter user infor and submits
      | firstname  | lastname | subscribed | assistance | email               | password | passwordconfimation | showPassword |
      | Paw Patrol | Disney   | false      | false      | California@test.com | Abc@1234 | Abc@1234            | true         |
    Then validate the email address shows on the accout page
      | email | California@test.com |
