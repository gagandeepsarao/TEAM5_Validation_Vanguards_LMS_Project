@Batch
Feature: Edit Batch

  Background: Logged on the LMS portal
              Admin is on dashboard page after Login
              Admin clicks "Batch" from navigation bar

    Given Admin is in Home Page
    When Admin enter valid credentials and clicks login button
    Then Admin should land on dashboard page
    When Admin clicks on "Batch" from navigation bar

    @Edit1
    Scenario: Admin Validate row level edit icon
    Given   Check edit icon on row level in data table is enabled
    Then    Admin clicks the edit icon
    Then    A new pop up with Batch details appears

    @Edit2  
     Scenario: Check if the fields are updated
     Given  Admin clicks the edit icon
     When   Update the fields with valid and click save
 
    @Edit3   
    Scenario: Check if the update throws error with invalid value
     Given Admin clicks the edit icon
     When  Update the fields with invalid values and click save
     Then  Error message should display in the invalid fields
      
      
      @Edit4   
      Scenario: Check if you get error message when mandatory fields are erased
      Given Admin clicks the edit icon
      When  Erase data from mandatory field
      Then Error message should appear in the mandatory field
      
      
      
       
      @Edit5  
      Scenario: Check if description field is optional in update
   Given Admin clicks the edit icon
     When  Erase data from description field
      Then   updated batch details should appear on the data table
      