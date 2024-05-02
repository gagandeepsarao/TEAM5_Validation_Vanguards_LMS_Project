@Batch
Feature: Delete Multiple Batches

  Background: Logged on the LMS portal
              Admin is on dashboard page after Login
              Admin clicks "Batch" from navigation bar

    Given Admin is in Home Page
    When Admin enter valid credentials and clicks login button
    Then Admin should land on dashboard page
    When Admin clicks on "Batch" from navigation bar

   @delall1
   Scenario: Validate the delete icon that present below the header
    Given  No checkboxes in the datatable are selected
    Then The delete icon under the "ManageBatch" header should be disabled
  
  
  @delall2
  Scenario: Check for the single row delete
      Given select one of the checkbox/row
       When Click the delete icon below "Manage Batch" header
       Then The respective row in the data table is deleted
     
     
     
     
 @delall3
  Scenario:  Check for the multi row delete
      Given  Two or more checkboxes/row is selected
       When Click delete icon below "Manage Batch" header
       Then The respective row in the data table is deleted
    