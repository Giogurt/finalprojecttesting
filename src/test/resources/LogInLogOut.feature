Feature: LogIn and LogOut
 
  Scenario: Client logins with valid credentials
  	Given the user is on the login page
  	When she fills in "username" with "tomsmith"
  	And she fills in "password" with "SuperSecretPassword!"
  	And she presses "radius"
  	Then she is redirected to the next page
  	And she sees "You logged into a secure area!"
  	
  Scenario: Client logins with invalid credentials
  	Given the user is on the login page
  	When she fills in "username" with "tomsmith"
  	And she fills in "password" with "wrong"
  	And she presses "radius"
  	Then she is redirected to the next page
  	And she sees "Your password is invalid!" 
