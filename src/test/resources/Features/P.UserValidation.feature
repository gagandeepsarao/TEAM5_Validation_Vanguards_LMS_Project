Feature: User page validation

Background: Logged on the LMS portal as admin
	
@Tag1
Scenario: Validate landing in User page	
	Given Admin is on dashboard page after LMS Login
	When Admin clicks User from navigation bar
	Then Admin should see the User in the URL

@Tag2	
Scenario: Validate the heading
	Given Admin is on dashboard page after LMS Login
	When Admin clicks User from navigation bar
	Then Admin should see a heading with text Manage user on the page
	
@Tag3
Scenario: Validate the text and pagination icon below the data table
	Given Admin is on dashboard page after LMS Login
	When Admin clicks User from navigation bar
	Then Admin should see the text as Showing x to y of z entries along with Pagination icon below the table

@Tag4
Scenario: Validate data table headers in the User Page
	Given Admin is on dashboard page after LMS Login
	When Admin clicks User from navigation bar
	Then Admin Should see the data table with column names Id, Name, location, Phone Number, EditOrDelete

@Tag5
Scenario: Validating the default state of Delete button
	Given Admin is on dashboard page after LMS Login
	When Admin clicks User from navigation bar
	Then Admin should see a Delete button on the user page on top left hand side as Disabled

@Tag6
Scenario: Validate Add New user button in User Page
	Given Admin is on dashboard page after LMS Login
	When Admin clicks User from navigation bar
	Then Admin should be able to see the Add New User button above the data table	

@Tag7
Scenario: Validate Assign staff button in User page
	Given Admin is on dashboard page after LMS Login
	When Admin clicks User from navigation bar
	Then Admin should be able to see the Assign staff button above the data table	
	
@Tag8
Scenario: Validate Assign student button in User page
	Given Admin is on dashboard page after LMS Login
	When Admin clicks User from navigation bar
	Then Admin should be able to see the Assign Student button above the data table
	
@Tag9
Scenario: Validate search box in User page
	Given Admin is on dashboard page after LMS Login
	When Admin clicks User from navigation bar
	Then Admin should be able to see the search text box above the data table
	
@Tag10
Scenario: Validate number of data rows in the data table
	Given Admin is on dashboard page after LMS Login
	When Admin clicks User from navigation bar
	Then Admin should see two records displayed on the data table
	
@Tag11
Scenario: Verify Check box on the data table
	Given Admin is on dashboard page after LMS Login
	When Admin clicks User from navigation bar
	Then Each row in the data table should have a checkbox
	
@Tag12
Scenario: Verify edit icon on the data table
	Given Admin is on dashboard page after LMS Login
	When Admin clicks User from navigation bar
	Then Each row in the data table should have a edit icon that is enabled

@Tag13
Scenario: Verify  delete icon on the data table
	Given Admin is on dashboard page after LMS Login
	When Admin clicks User from navigation bar
	Then Each row in the data table should have a delete icon that is enabled	