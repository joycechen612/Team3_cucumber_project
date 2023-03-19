@updateOrderQty
Feature: 

  @ui
  Scenario: 
    Given user login zulily account
      | username | joycechen612@gmail.com |
      | password | Qwert12345!            |
    Then user add one specific product to the shopping basket
      | productName | LEGO® Star Wars™ 75350 Clone Commander Cody™ Helmet |
    Then user should see this product on Shopping Basket page
    And user click edit button change the order quantity to "5" then click update
    Then the order quantity should change to updated number
    
