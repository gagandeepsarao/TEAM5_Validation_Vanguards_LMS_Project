#Author: Aswini

@Program
Feature: Manage Program Validation

Background: Logged on the LMS portal as Admin 
Given Admin is in Home Page
When Admin enter valid credentials and clicks login button 

  @TS1
  Scenario: Validate landing in Program page
    Given Admin is on dashboard page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see URL with "Manage Program"
    
  @TS2
  Scenario: Validate the heading
    Given Admin is on dashboard page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see a heading with text "Manage Program" on the page
   
 @TS3
  Scenario: Validate the text and pagination icon below the data table
   Given Admin is on dashboard page after Login
   When Admin clicks "Program" on the navigation bar
   Then Admin should see the text as "Showing x to y of z entries" along with Pagination icon below the table. 
		
 @TS4
  Scenario: Validate the footer
   Given Admin is on dashboard page after Login
   When Admin clicks "Program" on the navigation bar
   Then Admin should see the footer as "In total there are z programs" z- Total number of records 
	 
	 @TS5
  Scenario: Validating the default state of Delete button
   Given Admin is on dashboard page after Login
   When Admin clicks "Program" on the navigation bar
   Then Admin should see a Delete button on the top left hand side as Disabled 
	 
	  @TS6
  Scenario: Validate Add New Program 
   Given Admin is on dashboard page after Login
   When Admin clicks "Program" on the navigation bar
   Then Admin should see a "+A New Program" button on the program page above the data table 
	
	 @TS7
  Scenario: Validate that number of records (rows of data in the table) displayed 
   Given Admin is on dashboard page after Login
   When Admin clicks "Program" on the navigation bar
   Then Admin should see the number of records (rows of data in the table) displayed on the page are 5 
	
	@TS8
  Scenario: Verify data table on the Program page 
   Given Admin is on dashboard page after Login
   When Admin clicks "Program" on the navigation bar
   Then Admin should see data table on the Manage Program Page with following column headers (Program Name, Program Description, Program Status, Edit,Delete) 
	
	@TS9
  Scenario: Verify Sort arrow icon on the data table 
   Given Admin is on dashboard page after Login
   When Admin clicks "Program" on the navigation bar
   Then Admin should see the sort arrow icon beside to each column header except Edit and Delete 
	
	@TS10
  Scenario: Verify Check box on the data table 
   Given Admin is on dashboard page after Login
   When Admin clicks "Program" on the navigation bar
   Then Admin should see check box on the left side in all rows of the data table  
	 
	 @TS11
  Scenario: Verify Edit and Delete buttons 
   Given Admin is on dashboard page after Login
   When Admin clicks "Program" on the navigation bar
   Then Admin should see the Edit and Delete buttons on each row of the data table  
	 
	  @TS12
  Scenario: Verify Search bar on the Program page 
   Given Admin is on dashboard page after Login
   When Admin clicks "Program" on the navigation bar
   Then Admin should see Search bar with text as "Search..."  
	

####     Validates Sorting(data ordering) on the Program Data table

	@TS13
  Scenario: Validates Sorting(data ordering) ascending on the Program Data table - ProgramName 
   Given Admin is on Manage Program page after clicking on 'Program' button on navigation bar
   When Admin clicks the sort icon of program name column
   Then The data get sorted on the table based on the program name column values in ascending order 

   
	@TS14
  Scenario: Validates Sorting(data ordering) descending on the Program Data table - ProgramName 
   Given The data is in the ascending order on the table based on Program Name column
   When Admin clicks the sort icon of program name column
   Then The data get sorted on the table based on the program name column values in descending order 
   
   
   	@TS15
  Scenario: Validates Sorting(data ordering) ascending on the Program Data table - Program Description 
   Given Admin is on Manage Program page after clicking on 'Program' button on navigation bar
   When Admin clicks the sort icon of program description column
   Then The data get sorted on the table based on the program description column values in ascending order 

   
	@TS16
  Scenario: Validates Sorting(data ordering) descending on the Program Data table - Program Description
   Given The data is in the ascending order on the table based on Program Description column
   When Admin clicks the sort icon of program description column
   Then The data get sorted on the table based on the program description column values in descending order 
   
   
   @TS17
  Scenario: Validates Sorting(data ordering) ascending on the Program Data table - Program Description 
   Given Admin is on Manage Program page after clicking on 'Program' button on navigation bar
   When Admin clicks the sort icon of program status column
   Then The data get sorted on the table based on the program status column values in ascending order 

   
	@TS18
  Scenario: Validates Sorting(data ordering) descending on the Program Data table - Program Description
   Given The data is in the ascending order on the table based on Program status column
   When Admin clicks the sort icon of program status column
   Then The data get sorted on the table based on the program status column values in descending order 
   
	
	### Pagination
	
	 @TS19
  Scenario: Verify Next page link 
   Given Admin is on Manage Program Page after logged in
   When Admin clicks Next page link on the program table 
   Then Admin should see the Pagination has "Next" active link  
   
 @TS20
  Scenario: Verify Last page link 
   Given Admin is on Manage Program Page after logged in
   When Admin clicks Last page link 
   Then Admin should see the last page record on the table with Next page link are disabled  
   
   @TS21
  Scenario: Verify Prev page link 
   Given Admin is on last page of Program table
   When Admin clicks Prev page link 
   Then Admin should see the previous page record on the table with pagination has previous page link  
   
   @TS22
  Scenario: Verify Start page link 
   Given Admin is on Previous Program page 
   When Admin clicks Start page link 
   Then Admin should see the very first page record on the table with Previous page link are disabled  
   
   	### Navigation Validation from Manage Program to other Pages
	
	 @TS23
  Scenario: Batch link on navigation bar 
   Given Admin is on Manage Program page after clicking on 'Program' button on navigation bar
   When Admin clicks on Batch link on Manage Program page
   Then Admin is re-directed to Batch page  
   
   @TS24
  Scenario: Batch link on navigation bar 
   Given Admin is on Manage Program page after clicking on 'Program' button on navigation bar
   When Admin clicks on User link on Manage Program page
   Then Admin is re-directed to User page  
	
	@TS25
  Scenario: Batch link on navigation bar 
   Given Admin is on Manage Program page after clicking on 'Program' button on navigation bar
   When Admin clicks on Logout link on Manage Program page
   Then Admin is re-directed to Login page  
	

