@Batch
Feature: Batch Page Validation

  Background: Logged on the LMS portal
    Given Admin is in Home Page
    When Admin enter valid credentials and clicks login button

  @Tag1
  Scenario: Validate user is able to landing in the  Batch page
    Given Admin is on dashboard page after Login
    When Admin clicks on "Batch" from navigation bar
    Then Admin should see the "Manage Batch" in the URL

  @Tag2
  Scenario: Validate header in the BatchPage
    Given Admin is on dashboard page after Login
    When Admin clicks on "Batch" from navigation bar
    Then Admin should see the "Manage Batch" heading  in the header

  @Tag3
  Scenario: Validate user able to do pagination in the Batch Page
    Given Admin is on dashboard page after Login
    When Admin clicks on "Batch" from navigation bar
    Then Admin should see the pagination controls under the data table

  @Tag4
  Scenario: Validate data table headers in the Batch Page
    Given Admin is on dashboard page after Login
    When Admin clicks on "Batch" from navigation bar
    Then Admin should see data table on the Manage Batch Page with following column headers Batch Name, Batch Description, Batch Status,No. of classes,Program Name,Edit,Delete

  @Tag5
  Scenario: Validate admin able to see Delete button in Batch Page
    Given Admin is on dashboard page after Login
    When Admin clicks on "Batch" from navigation bar
    Then Admin should be able to see the "Delete" icon button that is disabled

  @Tag6
  Scenario: Validate "+ A New batch" in Batch Page
    Given Admin is on dashboard page after Login
    When Admin clicks on "Batch" from navigation bar
    Then Admin should be able to see the "+ A New batch" button

  @Tag7
  Scenario: Validate data rows
    Given Admin is on dashboard page after Login
    When Admin clicks on "Batch" from navigation bar
    Then Admin should check Each row in the data table should have a checkbox Also check Each row in the data table should have a edit icon that is enabled and check Each row in the data table should have a delete icon that is enabled

  @Tag8
  Scenario: Validate pop up for adding batch
    Given Admin is on dashboard page after Login
    When Admin clicks "+ A New Batch" button
    Then Admin get A new pop up with Batch details appears
