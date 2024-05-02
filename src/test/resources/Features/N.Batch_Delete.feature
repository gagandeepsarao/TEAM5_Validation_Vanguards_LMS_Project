@Batch
Feature: Delet Batch

  Background: Logged on the LMS portal
              Admin is on dashboard page after Login
              Admin clicks "Batch" from navigation bar

    Given Admin is in Home Page
    When Admin enter valid credentials and clicks login button
    Then Admin should land on dashboard page
    When Admin clicks on "Batch" from navigation bar

  @del1
  Scenario: Validate row level delete icon
    Given The delete icon on row level in data table is enabled
    When Admin clicks the delete icon
    Then Alert appears with yes and No option

  @del2
  Scenario: Validate accept alert
    Given Admin clicks the delete icon
    When You click yes option
    Then Batch deleted alert pops and batch is no more available in data table

    
    
    @del3
  Scenario: Validate reject alert
    Given Admin clicks the delete icon
    When You click No option
    Then Batch is still listed in the data table
    