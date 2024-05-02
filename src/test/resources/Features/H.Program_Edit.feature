Feature: Edit Program Details

Background: Admin is on Manage Program Page after clicks Program on the navigation bar
Given Admin is in Home Page
When Admin enter valid credentials and clicks login button
Then Admin clicks a edit button in the manage program page

Scenario: Edit Program Name

Given Admin is on Program Details Popup window to Edit
When Admin edits the Name column and clicks save button
Then Admin gets a message "Successful Program Updated" alert and able to see the updated name in the table for the particular program

Scenario: Edit Program description

Given Admin is on Program Details Popup window to Edit
When Admin edits the Description column and clicks save button
Then Admin gets a message "Successful Program Updated" alert and able to see the updated description in the table for the particular program

Scenario: Change Program Status

Given Admin is on Program Details Popup window to Edit
When Admin changes the Status and clicks save button
Then Admin gets a message "Successful Program Updated" alert and able to see the updated status in the table for the particular program

Scenario: Validate Cancel button on Edit popup

Given Admin is on Program Details Popup window to Edit
When Admin clicks <Cancel>button on edit popup
Then Admin can see the Program details popup disappears and can see nothing changed for particular program

Scenario: Validate Save button on Edit popup

Given Admin is on Program Details Popup window to Edit
When Admin clicks <Save>button on edit popup
Then Admin gets a message "Successful Program Updated" alert and able to see the updated details in the table for the particular program




