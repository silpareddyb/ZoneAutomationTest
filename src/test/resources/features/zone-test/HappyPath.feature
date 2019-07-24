Feature: Login to AutomationPractice website to order a T-shirt and register during checkout
When As a User, Goto AutomationPractice website
I want to order a Dress and checkout to purchase using wire
So that the order will submit by creating account during checkout

  Background:
   Given I am on AutomationPractice Application

  #  Happy Path
  @test
  Scenario: Place an order and register during checkout and pay via wire
    When I Select an item in 'DRESSES' and click Add to Cart
    And Click Proceed to checkout button
    Then Create an account during checkout
    And Accept Terms and Condition for payment
    Then Select Payment method via Wire and confirm the order
    And I verify the selected order is done
    And Sign off the application


#  Change the item size and color before purchasing scenarios
  @test
  Scenario: Change the size of item before purchasing
    When I Select an item in 'DRESSES' tab
    And change the size of the selected item to 'M'
    Then I should see dropdown Option for product attribute as 'M'

  @test
  Scenario: Change the size of item before purchasing
    When I Select an item in 'DRESSES' tab
    And change the color of the selected item to 'Pink'
    Then I should see dropdown Option for product attribute as 'Pink'

  @test
  Scenario: Quick view on the selected item
    When I Select an item and click for quick view
    Then I should see quick view of the selected items

