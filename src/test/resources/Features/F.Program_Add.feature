Feature: Add new Program

Background: Admin is on dashboard page after Login and clicks Program on the navigation bar
Given Admin is in Home Page
When Admin enter valid credentials and clicks login button

Scenario: Validate Program Details Popup window

Given Admin is on Manage Program Page
When Admin clicks <A New Program>button
Then Admin should see a popup open for Program details with empty form along with <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window

Scenario: Validate input fields and their text boxes in Program details form

Given Admin is on Manage Program Page 
When Admin clicks <A New Program>button
Then Admin should see two input fields and their respective text boxes in the program details window

Scenario: Validate radio button for Program Status 

Given Admin is on Manage Program Page   
When Admin clicks <A New Program>button
Then Admin should see two radio button for Program Status

Scenario: Validate Edit Feature 

Given Admin is on Manage Program Page
When Admin clicks <Edit> button on the data table for any row
Then Admin should see a popup open for Program details to edit

Scenario: Delete Feature

Given Admin is on Manage Program Page
When Admin clicks <Delete> button on the data table for any row
Then Admin should see a alert open with heading "Confirm" along with  <YES> and <NO> button for deletion

Scenario: Validate details for Confirm Deletion form

Given Admin is on Manage Program Page
When Admin clicks <Delete> button on the data table for any row
Then Admin should see a message "Are you sure you want to delete <Program name>?"


