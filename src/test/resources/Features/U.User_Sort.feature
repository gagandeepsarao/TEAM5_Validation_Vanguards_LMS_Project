Feature: Sort user

Background: Admin is on dashboard page after Login and clicks User on the navigation bar
	Given Admin is on the login screen
	When Admin enters valid username and password
	Then Admin should see the dashboard page
	And clicks User on the navigation bar	

	
	@tag1
	Scenario:
	Given Admin is on Manage User Page
	When Admin clicks on ID sort icon
	Then Admin should see User details are sorted by id in ascending order
	When Admin clicks on ID sort icon
	Then Admin should see User details are sorted by id in descending order
	