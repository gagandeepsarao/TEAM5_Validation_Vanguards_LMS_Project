Feature: Multiple Delete Program

Background: Admin clicks delete button under header after selecting the check box in the data table
Given Admin is in Home Page
When Admin enter valid credentials and clicks login button
Then Admin clicks the delete button in the manage program page

Scenario: Validate multiple program deletion by selecting Single checkbox

Given Admin is on Confirm Deletion alert
When Admin clicks <YES> button on the alert
Then Admin should land on Manage Program page and can see the selected program is deleted from the data table

Scenario: Validate multiple program deletion by selecting Single checkbox

Given Admin is on Confirm Deletion alert
When Admin clicks <NO> button on the alert
Then Admin should land on Manage Program page and can see the selected program is not deleted from the data table


Scenario: Click Yes on deletion window

Given Admin is on Confirm Deletion alert
When Admin clicks <YES> button on the alert
Then Admin gets a message "Successful Program Deleted" alert and able to see that program deleted in the data table

Scenario: Click Yes on deletion window

Given Admin is on Confirm Deletion alert
When Admin clicks <NO> button on the alert
Then Admin can see the deletion alert disappears without deleting


#Scenario: Click Yes on deletion window
#
#Given Admin is on Confirm Deletion alert
#When Admin clicks Cancel Icon on Deletion alert
#Then Admin can see the deletion alert disappears without any changes

