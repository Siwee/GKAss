@regression
Feature: SWAGLABS Shopping

  Scenario:Successful user login
    Given I navigate to the SWAGLABS URL
    When I login using accepted user credentials
    Then I am successfully logged in and can see the products page

  Scenario:Add items to cart
    Given I have logged in and in products page
    When I add items to cart
    Then Items are added to cart

  Scenario:Order products from SWAGLABS website
    Given I have login and in products page
    And I add new items to cart
    When I place an order
    Then Order is complete and the complete order information is displayed