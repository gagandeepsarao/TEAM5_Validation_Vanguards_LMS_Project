Feature: Add new user

Background: Admin is on the Manage User Page after clicking on User on the navigation bar
	Given Admin is on the login screen
	When Admin enters valid username and password
	Then Admin should see the dashboard page
	And clicks User on the navigation bar	

@tag1
Scenario: Check if user is created when only mandatory fields are entered with valid data
  Given Admin is on User Details Popup
  Then Admin should see pop up open with textboxes for user details columns
  When Admin enters mandatory fields in the form and clicks on submit button
  Then Admin gets message User added Successfully

# -------> YET TO DO <------- STILL KEPT PENDING AS ALL FIELDS ARE MANDATORY FOR ADD NEW USER MENU.
#@tag2
#Scenario: Check if user is created when only optional fields are entered with valid data
  #Given Admin is on User Details Popup
  #When Admin skips to add value in mandatory field
  #Then Admin should see error message below the test field and the field will be highlighed in red color  
#-------> YET TO DO <-------

@tag3
Scenario: check if user is created when invalid data is entered in all of the fields
  Given Admin is on User Details Popup
  When Admin enters invalid data in all of the  "<fields>" with "<values>" in the form and clicks on submit button
			  |FirstName	|	FirstT5 	|
			  |MidName		|	MidT5	|
			  |LastName		|	LastnameT5|
			  |Location		| 11223344 |
			  |Phone			| xxxxxxxx  |
			  |LinkedinURL| www.-.com|
			  |UserRole		| R01					|
			  |UserStatus	| Active			|
			  |VisaStatus	| H4					|
			  |eMail			| email@gmail |
			  |UGDegree		| 232323			|
			  |PGDegree		| 232323			|
			  |Timezone		| 12345			|
			  |Comments		| \/\/\/\/\/|
  Then Admin gets error message and user is not created  
  
@tag4
Scenario: Empty form submission
  Given Admin is on User Details Popup
  When Admin clicks on submit button without entering data 
  Then user wont be created and Admin gets error message

@tag5
Scenario: Validate CancelClose(X) icon on User Details form
  Given Admin is on User Details Popup
  When Admin clicks CancelCloseX Icon on User Details form 
  Then User Details popup window should be closed without saving  
  
@tag6
Scenario: Validate Cancel button on User Details form
  Given Admin is on User Details Popup
  When Admin clicks Cancel button 
  Then Admin can see the User details popup disappears without adding any user  
  
@tag7
Scenario Outline: Check if the user details are added in data table
  Given Admin is on User Details Popup
  Then Admin should see pop up open with textboxes for user details columns
  Then Fill in all the "<ColName>" with valid "<Values>" and click submit
  
  |FirstName	|	FiveFname 	|
  |MidName		|	FiveMidname	|
  |LastName		|	FiveLastname|
  |Location		| FiveLocation|
  |Phone			| 9516238516  |
  |LinkedinURL| www.linkedin.com|
  |UserRole		| R01					|
  |UserStatus	| Active			|
  |VisaStatus	| H4					|
  |eMail			| FiveFname516@gmail.com|
  |UGDegree		| UserUG			|
  |PGDegree		| UserPG			|
  |Timezone		| EST					|
  |Comments		| UserComments|
  
 Then The newly added user should be present in the data table in Manage User page