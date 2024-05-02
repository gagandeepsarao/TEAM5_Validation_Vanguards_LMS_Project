@Batch
Feature: Add new Batch

  Background: Logged on the LMS portalAdmin is on dashboard page after Login
              Admin clicks "Batch" from navigation bar
              Admin clicks "+ A New Batch" button

    Given Admin is in Home Page
    When  Admin enter valid credentials and clicks login button
    Then  Admin should land on dashboard page
    When  Admin clicks on "Batch" from navigation bar
    When  Admin clicks "+ A New Batch" button

  @tag1
  Scenario: Check if the BatchDetails fields exist in pop
    Given Admin checks a new pop up with Batchdetails appears
    Then  Admin should check  the pop up should include the Name and Description as text box,Program Name as drop down Status and status as radio button Number of classes as text box

  @tag2
  Scenario: Check if Batchdescription is optional field
    Given Admin checks a new pop up with Batch details appears
    When  Admin is able to Fill in all the fields except description with valid values and click save
    Then  The newly added batch should not be present in the data table in Manage Batch page

  @tag3
  Scenario: Admin Check if the programBatch details are added in data table
     Given  Admin checks a new pop up with Batch details appears
    When    Admin is Fill in all the fields with valid values and click save
    Then    The newly added batch should be present in the data table in Manage Batch page

  @tag4
  Scenario: Check for error messages for invalid fields
    Given  Admin checks a new pop up with Batch details appears
    When   Check if any of the fields have invalid values
    Then   Error message should appear

  @tag5
  Scenario: Check for error messages for mandatory fields
    Given Admin checks a new pop up with Batch details appears
    When Check any of the mandatory fields are blank
    Then Error message should display
