@addToCart
Feature: Verify addToCart Function

  @ui
  Scenario: 
    Given user login zulily account
      | username | joycechen612@gmail.com |
      | password | Qwert12345!            |
    Then user enter one specific product name in the search box
      | productName | LEGO® Star Wars™ 75350 Clone Commander Cody™ Helmet |
    Then the product should show up then user click it
    And user click add to basket button
    Then user should see this product on Shopping Basket page
     
