
	Feature: Login Page Validation

	Background: Admin gives the correct LMS portal URL
	    
	    Scenario: The admin gets an error message when invalid username and password is given
	    Given Admin is in Home Page
	    When Admin clicks login button with invalid credentials username and password
	    Then An Error message is displayed "Invalid username and password Please try again"
	    
	    
	   Scenario: The admin gets an error message for empty password field
		 Given Admin is in Home Page
	   When Admin clicks login button after entering username and password field empty 
		 Then Admin should get an Error message "Please enter your password"
	   
	   
	   Scenario: The admin gets an error mesage when with null username is given
		 Given Admin is in Home Page
	   When Admin clicks login button by entering only the password and username blank
		 Then Admin should get an Error message " Please enter your user name "

 
  	Scenario Outline: The admin is presented with an error message
	  Given The admin is on Home page
    When The admin enters "<username>", and "<password>"
    And  The admin clicks on the login button
    Then the user should see the error message indicating "<errormessage>"
      
    Examples:
      | username       					 | password     	  | errormessage                  																		 |
      | sdetorganizer@gmail.com  | UIHackathon@01   | "Invalid username and password Please try again"                   |
      | ssdddd								   | asdsd         		| "Please enter username and password in correct format" 			   		 |
      | sdetorganizers@gmail.com | UIHackathon@01 	| "Invalid password Please try again"  								 							 |
      | hhhhh      					 	   | UIHackathon@02   | "Please enter the username in correct format"     								 |
      | sdetorganizers@gmail.com | 1234         		| "The password is incorrect Please try again"          						 |
      |                          |               		| "Please fill out this field."         								 						 |
 		
 			
 			Scenario: The admin signs with correct credentials
			Given Admin is in Home Page
	    When Admin clicks login button after giving correct "sdetorganizers@gmail.com" and "UIHackathon@02"
	    Then Admin should land on dashboard page
	    
 
	Scenario: Verify login button action through keyboard
  Given Admin is in Home Page
	When Admin enter valid credentials  and clicks login button through keyboard
  Then Admin should land on dashboard page


	Scenario: Verify login button action through mouse
  Given Admin is in Home Page
  When Admin enter valid credentials  and clicks login button through mouse
  Then Admin should land on dashboard page

