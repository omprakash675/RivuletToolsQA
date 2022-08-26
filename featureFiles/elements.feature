
@elements
Feature: Testing element tab in Tool QA

  @url
  Scenario: Configuration and Entering URL
    Given Entering the URL

  @textbox
  Scenario: Testing Text Box
    Given Clicking the text box tab 
    And Entering name "Ram Kumar" email "ram@gmail.com" current address "Chennai" permanent address "Delhi"
    When Clicking submit button
    And Displaying and Verifying the Data
    
  @checkbox
  Scenario: Testing Check Box
    Given Clicking the Check tab 
    And Opening all the options 
    When Selecting the Notes in Desktop, angular in workplace, General in office and entire block of downloads
    Then Displaying the selected ones
    
  @radiobutton
  Scenario: Testing Radio button
    Given Clicking Radio button
    And Selecting the requird option
    Then Verifying the option
    
  @webtables
  Scenario: Testing Web tables
    Given Clicking Web tables
    When Adding new data to the tables name "Ram" lastname "Kumar" email "ram@gmail.com" age "23"
    And Adding rest of the data salary "40000" Dept "IT" and submitting
    And Deleting one of the table data
    Then Editing the exisiting data
    Then Searching the person data
    
  @buttons
  Scenario: Testing buttons
    Given Clicking buttons
    And Double clicking and displaying
    Then Right Clicking and Displaying
    Then Clicking the buttons
    
  @links
  Scenario: Testing links
    Given Clicking the link
    And Clicking the new tab links
    Then Clicking various option links and printing
 
  @brokenlinksandimages
  Scenario: Testing Broken link and Images
    Given Clicking the tab link
    And Checking the image is displayed or not
    Then Cheching whether it is valid link or not
    
  @uploadanddownload
  Scenario: Uploading and Downloading Test
    Given Clicking the uploading and downloading
    And Downloading the image
    Then Uplading the image
    
  @dynamicproperties
  Scenario: Checking Dynamic Properties
    Given Clicking the dynamic properties tab
    Then Displaying dynamic button text
    
  @quit
  Scenario: Exiting the browser
  Given Exiting the web browser
  
  @negativetestcase
  Scenario: Configuration and Entering URL for Negative TC
    Given Entering the URL for Negative TC
    Given Clicking the text box tab for Negative TC
    And Entering name "Ram Kumar" email "ram" current address "Chennai" permanent address "Delhi" for Negative TC
    Then submiting the Negative TC
  
  



