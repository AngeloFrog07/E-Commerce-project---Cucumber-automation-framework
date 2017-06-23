Feature: Logout
#@smoke @Chrome @Firefox
Scenario: Successful LogOut
Given User logged in
When User LogOut from main page
Then User cannot visit myaccount page
