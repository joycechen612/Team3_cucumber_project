@addToCart
Feature: Verify addToCart Function

  @ui
  Scenario: 
    Given user login zulily account
      | username | joycechen612@gmail.com |
      | password | Qwert12345!            |
    Then user enter one specific product name in the search box
      | productName | LEGO® Harry Potter™ 76420 Triwizard Tournament: The Black Lake V39 |
    Then the product should show up then user click it
    And user click add to basket button
    Then user should see this product on Shopping Basket page
     
