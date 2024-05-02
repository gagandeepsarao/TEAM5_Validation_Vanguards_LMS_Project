Feature: Dashboard Page 

		Background: Logged on the LMS portal as Admin 
	Given Admin is in Home Page
	When Admin enter valid credentials and clicks login button 
 

		Scenario: The Admin should see Manage Program as header
		When The admin is on dashboard page
		Then The admin should be able to see the heading Manage Program on the Dashboard Page
		
		Scenario: To verify that the maximum navigation time in milliseconds, defaults to 30 seconds
		When  The admin is on dashboard page
		Then The admin is able to verify the response time
		
		Scenario: The Admin should receive the link is broken if HTTP response >= 400
		Then The admin to verify that if  the link is broken
		
#		Scenario: Admin should see LMS on the left  side
#		When  The admin is on dashboard page
#		Then Admin should verify the LMS- Learning Management System is on the left  side


  	Scenario: Admin should see LMS - Learning Management System as Title
  	When The admin is on dashboard page
    Then Admin should be to able to verify LMS as title
    
    #Scenario: Admin should see LMS - Learning Management System as Title
    #When The admin is on dashboard page
    #Then Validate navigation bar text
   #
  
  #	Scenario Outline: THe admin is able to validate navigation bar text
  #	When The admin is on dashboard page 
    #Then Admin should see correct spelling in navigation bar text "input"
    #
    #Examples: 
    #|input|
    #|Program|
    #|Batch| 
    #|User|
    #|Logout|
#

  	Scenario Outline: The admin validates the correct spelling of LMS title and  space
  	When The admin is on dashboard page
    Then Admin should see correct spelling and space in LMS title "input"
    
    Examples: 
    |input|
    |LMS - Learning Management System| 

  #Scenario: Validate alignment for navigation bar
  #When The admin is on dashboard page
    #Then Admin should see the navigation bar text on the top right side
    #
  #Scenario: Validate navigation bar order 1st Program
  #When The admin is on dashboard page
    #Then Admin should see program in the 1st place
#
  #Scenario: Validate navigation bar order 2nd Batch
  #When The admin is on dashboard page
    #Then Admin should see batch in the 2nd place
#
  #Scenario: Validate navigation bar order 3rd User
  #When The admin is on dashboard page
    #Then Admin should see student in the 3rd user
#
  #Scenario: Validate navigation bar order 4th Logout
  #When The admin is on dashboard page
    #Then Admin should see student in the 4th logout
