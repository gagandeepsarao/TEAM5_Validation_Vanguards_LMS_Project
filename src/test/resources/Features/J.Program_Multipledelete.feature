Feature: Multiple Delete Program

Background: Admin clicks delete button under header after selecting the check box in the data table

Given Admin is in Home Page
When Admin enter valid credentials and clicks login button


Scenario: Validate multiple program deletion by selecting title checkbox

Given Admin is on Manage Program Page
When Admin clicks the header check box near the Program Name title
Then Admin should see all the other text box are selected for deletion 

Scenario: Validate program deletion by selecting Single checkbox

Given Admin is on Manage Program Page
When Admin click the check box near the program name created
Then Admin should see only the check box selected for deletion

