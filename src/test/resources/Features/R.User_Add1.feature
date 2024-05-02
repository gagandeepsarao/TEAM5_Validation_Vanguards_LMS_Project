Feature: Add new user

Background: Admin is on dashboard page after Login and clicks User on the navigation bar
	Given Admin is on the login screen
	When Admin enters valid username and password
	Then Admin should see the dashboard page
	And clicks User on the navigation bar	

@tag1
Scenario: Validate User Details Popup window
  Given Admin is on Manage User Page
  When Admin clicks Add New User button
  Then Admin should see pop up open for user details columns
  #			| First Name 	| Middle name | Last Name |
  #			| Location	 	| phone				| email			|
  #			| linkedinURL | User Role		| Role status | 
  #			|	visa status	| Undergraduate | postgraduate |
  #			| time zone		|	user comments | Cancel			|
  #			| Submit | close |
 
@tag2
Scenario: Validate input fields and text boxes in user details form
  Given Admin is on Manage User Page
  When Admin clicks Add New User button
  Then Admin should see pop up open with textboxes for user details columns
#				# First Name, Middle name, Last Name, Location,
#				# phone, email, linkedin url, Undergraduate, 
#				# postgraduate,time zone ,user comments

@tag3
Scenario: Validate drop downs in new user form
  Given Admin is on Manage User Page
  When Admin clicks Add New User button
  Then Admin should see dropdowns for userRole RoleStatus VisaStatus
  #			| User Role		| Role status |	visa status	|
