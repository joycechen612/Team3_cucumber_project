@address
Feature: verify add the address funtion

  @ui
  Scenario Outline: 
    Given user login zulily account
      | username | joycechen612@gmail.com |
      | password | Qwert12345!            |
    Then user click my account button
    Then user click account info
    Then user navigate to my account page
    And user click address book button
    And user click add an address on Address Book page
    Then user fill in the form then click save button
      | firstName | lastName | company  | Address       | city        | country      | state    | zipCode | Telephone  | Password    | notSave  | notSetDefault |
      | joyce     | chen     | boraTech | 6467 Mccoy Rd | centreville | United State | Virginia |   20121 | 5712251243 | Qwert12345! | false | false      |
    And the address should be save in the address book page
