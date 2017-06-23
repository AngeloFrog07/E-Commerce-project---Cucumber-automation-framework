Feature: Checkout process
Description: As a visitor of the ecommerce website
I want to be able to do a purchase
So that I can get the product that I want

#@smoke @Chrome
Scenario: Successful Product Checkout
Given User is logged
And User added an item to my shopping basket
When User proceeds to checkout
Then User should be able to make a payment
And The transaction should be successful

#@smoke @Chrome
Scenario: Unsuccessful Product Checkout
Given User added a product to my shopping basket
When User proceeded with the checkout
And User doesn't check terms
Then User should receive a warning message
