Feature: User page validation

Background: Logged on the LMS portal as admin
    #@Tag1
#Scenario: Validate landing in User page
#	Given Admin is on dashboard page after Login
#	When Admin clicks User from navigation bar
#	Then Admin should see the User in the URL
#
#@Tag2
#Scenario: Validate the heading
#	Given Admin is on dashboard page after Login
#	When Admin clicks User from navigation bar
#	Then Admin should see a heading with text Manage user on the page
#
#@Tag3
#Scenario: Validate the text and pagination icon below the data table
#	Given Admin is on dashboard page after Login
#	When Admin clicks User from navigation bar
#	Then Admin should see the text as Showing x to y of z entries along with Pagination icon below the table
#
#@Tag4
#Scenario: Validate data table headers in the User Page
#	Given Admin is on dashboard page after Login
#	When Admin clicks User from navigation bar
#	Then Admin Should see the data table with column names Id, Name, location, Phone Number, EditOrDelete
#
#@Tag5
#Scenario: Validating the default state of Delete button
#	Given Admin is on dashboard page after Login
#	When Admin clicks User from navigation bar
#	Then Admin should see a Delete button on the top left hand side as Disabled
#
#@Tag6
#Scenario: Validate Add New user button in User Page
#	Given Admin is on dashboard page after Login
#	When Admin clicks User from navigation bar
#	Then Admin should be able to see the Add New User button above the data table


Scenario: Validate row level delete icon
    Given Admin is on Manage User Page
    When Admin clicks the delete icon
    Then Admin should see a alert open with heading "Confirm" with  <YES> and <NO> button for deletion

#Delete Scenario dont run uncommented
#Scenario: Click Yes on deletion window
#      Given Admin should see a alert open with heading "Confirm" along with  <YES> and <NO> button for deletion
#      When  Admin clicks yes option
#      Then  Admin gets a message "User Deleted" alert and do not see that user in the data table

Scenario: Click No on deletion window
      Given Admin should see a alert open with heading "Confirm" with  <YES> and <NO> button for deletion
      When  Admin clicks  No option
      Then  Admin can see deletion alert disappears without deleting


Scenario: Validate Close(X) icon on Confirm Deletion alert
      Given Admin should see a alert open with heading "Confirm" with  <YES> and <NO> button for deletion
      When Admin clicks on close button
      Then Admin can see deletion alert disappears without any changes

Scenario: Validate Common Delete button enabled after clicking on any checkbox
      Given Admin is on the Manage User Page
      When  Admin clicks any checkbox in the data table
      Then  Admin should see common delete option enabled under header Manage Program

#Delete Scenario dont run uncommented
#Scenario: Validate multiple program deletion by selecting Single checkbox
#      Given Admin is on the Confirm Deletion alert
#      When Admin clicks yes option
#      Then Admin should land on Manage User page and can see the selected user is deleted from the data table

Scenario: Validate multiple program deletion by selecting Single checkbox
      Given Admin is on the Confirm Deletion alert
      When Admin clicks  No option
      Then Admin should land on Manage User page and can see the selected user is not deleted from the data table

#Delete Scenario dont run uncommented
Scenario: Validate multiple program deletion by selecting multiple check boxes
      Given Admin is on Confirm Deletion alert after selecting multiple checkboxes
      When  Admin clicks yes option
      Then Admin should land on Manage User page and can see the selected users are deleted from the data table

Scenario: Validate multiple program deletion by selecting multiple check boxes
      Given Admin is on Confirm Deletion alert after selecting multiple checkboxes
      When  Admin clicks  No option
      Then Admin should land on Manage User page and can see the selected users are not deleted from the data table

Scenario: Validate Assign Student Popup window
      Given Admin is on the Manage User Page
      When  Admin clicks "Assign Student" button
      Then Admin should see a pop up open for assign student details with empty form along with Save and Cancel button and close (X) icon on the top right corner of the window

Scenario: Validate input fields and their text boxes in Assign Student form
      Given Admin is on the Manage User Page
      When Admin clicks the "Assign Student" button
      Then Admin should see User Role as R03,and other fields Student Email id,Program Name,Batch Name and Status with respective input boxes.

Scenario:   Validate radio button in Assign Student Form
      Given Admin is on the Manage User Page
      When Admin clicks the "Assign Student" button
      Then Admin should see two radio button for Status

Scenario: Empty Form Submission
      Given Admin is in Assign Student details pop up page
      When  Admin clicks "Save" button with entering any data
      Then  Admin gets a Error message alert on page

Scenario: Validate the Assign Student form page without giving Student Email id
      Given Admin is in Assign Student details pop up page
      When Admin clicks "Save" button without entering Student Email id
      Then Admin gets a Error message alert as " User Email Id is required. "


Scenario: Validate the Assign Student form page without selecting Program
      Given Admin is in Assign Student details pop up page
      When Admin clicks "Save" button without selecting program
      Then Admin gets a Error message alert as " Program Name is required. "

Scenario: Validate the Assign Student form page without selecting batch
      Given Admin is in Assign Student details pop up page
      When Admin clicks "Save" button without selecting batch
      Then Admin gets a Error message alert as "Batch Name is required."

Scenario: Validate the Assign Student form page without giving Status
      Given Admin is in Assign Student details pop up page
      When Admin clicks "Save" button without giving status
      Then Admin gets a Error message alert as "Status is required."

Scenario: Validate Cancel or Close(X) icon on Assign Student form
      Given Admin is in Assign Student details pop up page
      When  Admin clicks Cancel or Close Icon on Assign Student form
      Then Assign Student popup window should be closed without saving

# need to verify by creating a new user
Scenario: Validate Save button on Assign Student form
      Given Admin is in Assign Student details pop up page
      When Enter all required fields with valid values and click Save button
      Then Admin gets a message "successfully" alert

Scenario: Validate Assign Staff Popup window
      Given Admin is on the Manage User Page
      When  Admin clicks "Assign Staff" button on Page
      Then  Admin should see a pop up open for assign staff details with empty form along with Save and Cancel button and close icon on the top right corner of the window

Scenario: Validate input fields and their text boxes in Assign Staff form
      Given Admin is on the Manage User Page
      When Admin clicks "Assign Staff" button on Page
      Then Admin should see User Role as R02,and other fields Student Email id,Skill,Program Name,Batch Name and Status with respective input boxes.

Scenario: Validate radio button in Assign Staff Form
      Given Admin is on the Manage User Page
      When Admin clicks "Assign Staff" button on Page
      Then Admin should see two radio button for User Status

Scenario: Empty Form Submission
      Given Admin is in Assign Staff details pop up page
      When Admin clicks "Save" button without entering any data on Assign User
      Then Admin gets an Error message alert

Scenario: Validate the Assign Staff form page without giving Student Email id
      Given Admin is in Assign Staff details pop up page
      When Admin clicks "Save" button without entering staff Email id
      Then Admin gets a Staff Error message alert as "Email Id is required."

#    Sceanrio will fail  Skill required message not displayed Bug
Scenario: Validate the Assign Staff form page without giving Skill
      Given Admin is in Assign Staff details pop up page
      When Admin clicks "Save" button without entering Skill
      Then Admin gets a Staff Error message alert as "Skill is required"

Scenario: Validate the Assign Staff form page without selecting Program
      Given Admin is in Assign Staff details pop up page
      When Admin clicks "Save" button without selecting program for Assign
      Then Admin gets a Staff Error message alert as "Program Name is required."

Scenario: Validate the Assign Staff form page without selecting batch
    Given Admin is in Assign Staff details pop up page
    When Admin clicks "Save" button without selecting batch for Assign
    Then Admin gets a Staff Error message alert as "Batch Name is required."

Scenario: Validate the Assign Staff form page without giving Status
    Given Admin is in Assign Staff details pop up page
    When Admin clicks "Save" button without selecting batch for Assign
    Then Admin gets a Error message alert as "Status is required."

Scenario: Validate Cancel or Close icon on Assign Staff form
      Given Admin is in Assign Staff details pop up page
      When Admin clicks Cancel or Close Icon on Assign Staff  form
      Then Assign Staff popup window should be closed without saving

Scenario: Validate Cancel button on Assign Staff form
      Given Admin is in Assign Staff details pop up page
      When Admin clicks the Cancel button
      Then Admin can see the Assign Staff popup disappears without assigning

#  need to create a new user each time
Scenario: Validate Save button on Assign Staff form
    Given Admin is in Assign Staff details pop up page
    When Enter all the required fields with valid values and click Save button on Assign Staff
    Then Admin gets a message "successfully" alert on the page










