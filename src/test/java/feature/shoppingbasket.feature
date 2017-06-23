Feature: Shoppingbasket
Description: As a visitor of the ecommerce website
I want to have a shopping cart
So that I can see the products and costs of what I want to purchase
#@smoke @Chrome @Firefox
Scenario: Adding a product to cart
Given User is on home page
When User clicks on add to cart button
Then User should see the product added to cart basket
And  User should see correct product details in the shopping cart summary page
#@smoke @Chrome @Firefox
Scenario: Removing a product from cart
Given User added an item to my shopping bag
When User clicks on remove icon on cart button
Then User should see the product removed to cart basket
And  the shopping cart should be empty