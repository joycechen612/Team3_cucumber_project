@searchBox
Feature: verify search box function

  @ui @LinonHome
  Scenario: 
    Given user come to Zulily homepage
    Then user enter "home" in the searchBox
    And user should verify all the drop down options contains keyword "home"
    Then user choose brand name "Linon Home"
    And verify "Linon Home" should on the each search result on first page

  @ui @jeans
  Scenario Outline: 
    Given user come to Zulily homepage
    Then user enter one specific product name in the search box
      | productName | <productName> |
    Then on the search header pick some filter
      | brandName   | departmentName   | subcategories   | priceRange   | size   |
      | <brandName> | <departmentName> | <subcategories> | <priceRange> | <size> |
    Then verify the result items meet the requirements

    Examples: 
      | productName | brandName         | departmentName | subcategories | priceRange | size           |
      #| jeans       | 7 For All Mankind | Women          | Pants         | $50 - $100 | XS (00-2)      |
      | dress       | Pixie Girl        | Girls          | Dresses       | $25 - $50  | 12 (big kid M) |
