Feature: User page validation

Background: Admin is on dashboard page after Login and clicks User on the navigation bar
	Given Admin is on the login screen
	When Admin enters valid username and password
	Then Admin should see the dashboard page
	And clicks User on the navigation bar
	
@Tag1
Scenario: search user by name	
	Given Admin is on Manage User Page
	When Admin enters username into search box.	
					| Five |
	Then Admin should see user displayed with the entered name

@Tag2
Scenario: Validating the Search with unrelated keyword
  Given Admin is on Manage User Page
  When Admin enters the keywords not present in the data table on the Search box 
  			| test-test |
  Then Admin should see zero entries on the data table