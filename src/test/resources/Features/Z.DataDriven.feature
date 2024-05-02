#Author: Aswini

@Program
Feature: Create Program Validation

Background: Logged on the LMS portal as Admin 
Given Admin is in Home Page
When Admin enter valid credentials and clicks login button 

  @TS1
  Scenario: Create Program with data from excel
   Given Admin is on Manage Program page after clicking on 'Program' button on navigation bar
   When Admin enters all the values and creates a program
     
    
@TS2
  Scenario: Create Batch with data from excel
    Given Admin is on dashboard page after Login
    When Admin clicks "+ A New Batch" button and enters all the values and creates a batch
  