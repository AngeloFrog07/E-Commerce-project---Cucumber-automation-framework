Feature: Login
Description: As a visitor of the ecommerce website
I want to be able to login with valid credentials
So that I can access to my account page 
#@smoke @Chrome @Firefox
Scenario: Successful Login	with valid	credentials
Given user is on the homepage
When User enters valid email and password
# or When User enters a valis email as "testangelo@email.com" and a password as "test123"
Then User can	visit the account page
#@smoke @Chrome @Firefox
Scenario: Failed Login with invalid	email
Given user is on the homepage
When User enters an invalid email
Then Invalid email Message is displayed
#@smoke @Chrome @Firefox
Scenario: Failed Login with invalid	password
Given user is on the homepage
When User enters an invalid password
Then Invalid password Message is displayed