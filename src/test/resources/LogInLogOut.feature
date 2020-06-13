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
  	
   Scenario: A logged in client logs out from the account
  	Given the user is on the login page
  	When she fills in "username" with "tomsmith"
  	And she fills in "password" with "SuperSecretPassword!"
  	And she presses "radius"
  	Then she is redirected to the next page
  	And she presses "radius"
  	Then she is redirected to the next page
  	And she sees "You logged out of the secure area!"
  	
  	Scenario: Client access secure page without logging in
  	Given the user is on the secure page
  	Then she sees "You must login to view the secure area!"
  	