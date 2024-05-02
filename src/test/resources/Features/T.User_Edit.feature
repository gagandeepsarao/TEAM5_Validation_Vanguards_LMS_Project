Feature: Edit new user

Background: Admin is on dashboard page after Login and clicks User on the navigation bar 
	Given Admin is on the login screen
	When Admin enters valid username and password
	Then Admin should see the dashboard page
	And clicks User on the navigation bar	

@Tag1
Scenario: Validate row level edit icon
	Given Admin is on Manage User Page
	When Admin clicks on the edit icon 
	Then A new pop up with User details appears
	
@Tag2
Scenario: Check if the fields are updated with valid data
				# Given Admin clicks the edit button - New Gherkin to be added.
	Given Admin is on Edit User details pop up
	When Update the "<fields>" with valid data and click submit
				|FirstName	|	
			  |MidName		|	
			  |LastName		|	
			  |Location		| 
			  |Phone			| 
			  |LinkedinURL| 
			  |UserRole		| 
			  |UserStatus	| 
			  |VisaStatus	| 
			  |eMail			| 
			  |UGDegree		| 
			  |PGDegree		| 
			  |Timezone		| 
			  |Comments		|   
Then Admin gets success message and see the updated values in data table

# ----------->   YET TO DO   <----------
#@Tag3	
#Scenario: Check if the fields are updated with invalid values
#	Given Admin is on User details pop up
#	When Update the fields with invalid values and click submit
#	Then Admin should get Error message 

#@Tag4
#Scenario: Check if the mandatory fields are updated with valid data
#	Given Admin is on User details pop up
#	When Update the mandatory fields with valid values and click submit
#	Then Admin gets "<message>" and see the updated values in data table
#				| "User updated Successfully " |

#@Tag5
#Scenario: Check if the optional fields are updated with valid data
#	Given Admin is on User details pop up
#	When Update the optional fields with valid values and click submit
#	Then Admin gets "<message>" and see the updated values in data table
#				| "User updated Successfully " |

#@Tag6
#Scenario: Validate invalid values in the text fields
#	Given Admin is on User details pop up
#	When Admin enters only numbers or special char in the text fields
#	Then Admin should get Error message 

#@Tag7
#Scenario: Validate Cancel button on Edit popup
#	Given Admin is on User details pop up
#	When Admin clicks Cancel button on edit popup
#	Then Admin can see the User details popup disappears and can see nothing changed for particular User