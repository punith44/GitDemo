Feature: My Information Page

@regression @MyInfo
Scenario: Upload the File
Given I Navigate to Orange HRM URL And Login to the Application
Then I Click on "My Info" Link on Main Page
Then I Validate Tooltip is Present or Not on image Icon
When I Choose the Image and Click on Upload Button
