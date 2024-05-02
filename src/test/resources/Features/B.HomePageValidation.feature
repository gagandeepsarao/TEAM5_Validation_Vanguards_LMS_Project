
Feature: Home Page Verification

  Background: 
  
    Given Admin Launch the Browser

		Scenario: Admin should land on the home page
  	When Admin gives the LMS portal URL
		Then Admin should be able to land on the LMS homepage

  	Scenario: The Admin should recieve an error message  for 404 page not found 
 	When Admin gives the incorrect LMS portal URL
		Then The admin lands on home page with invalid URL


		Scenario: The Admin should receive the link is broken if HTTP response >= 400
		When Admin gives the correct LMS portal URL
		Then The admin to verify that if  the link is broken
	
		Scenario: The Admin should to verify to see correct spellings in all fields 
		When Admin gives the correct LMS portal URL
		Then Admin should see correct spellings in all fields 
	
  	Scenario: Admin should see logo on the left  side
  	When Admin launched the browser
		Then Admin should verify the logo is on the left  side


  	Scenario: Admin should see  LMS - Learning Management System
	 	When Admin launched the browser
    Then Admin should be to able to verify application name
      	
    Scenario: THe Admin should be able to see company name below the app name
		When Admin launched the browser
    Then Admin should be able to verify the company name below the app name

  	Scenario: Admin should see "Please login to LMS application"
		When Admin launched the browser
    Then Admin should validate the sign in content
      
    Scenario: The Admin should see two text field
    When Admin launched the browser
    Then Admin should verify that text field is present

       
    Scenario: Admin should see the word "user" in the first text 
		When Admin launched the browser
    Then Admin should verify that the word "user" in the first text field

		Scenario: Admin should see * symbol next to user text
	 	When Admin launched the browser
    Then Admin should verify that the symbol asterik is next to user text
    
  	Scenario: Admin should see the word "password" in the second text field
	 	When Admin launched the browser
    Then Admin should verify in the second text field the word "password" 
 

  	Scenario: Admin should see * symbol next to password text
	 	When Admin launched the browser
    Then Admin should to verify asterik next to password text


  	Scenario: Admin should see input field on the centre of the page
  	When Admin launched the browser
    Then Admin should be able to verify the alignment input field for the login

    
  	Scenario: Admin should see login button 
	 	When Admin launched the browser
    Then Admin should be able to verify that Login button is present

    
  	Scenario: Admin should see login button on the centre of the page
	 	When Admin launched the browser
    Then Admin should be able to verify the alignment of the login button

     
  	Scenario: The admin should see username in gray color
  	When Admin launched the browser
    Then Admin is able to verify the input descriptive test in user field

    Scenario: Admin should see the password field in gray color
  	When Admin launched the browser
  	Then Admin should be able to verify input descriptive test in password field



   