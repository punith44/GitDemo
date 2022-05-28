Feature: Automating Amazon WebSite

@amazon @NavigationCommands
Scenario: Handelling Navingation Commands
Given I Navigate to Amazon url
When I Click On "Mobiles" menu Link
Then I check whether I am on Mobile Phones Page
Then I perform Some Navigation Commands


@amazon @search
Scenario: Handelling Search Elements
Given I Navigate to Amazon url
When I search product "Apple" Keyword
Then I select "charger" product


@amazon @ScreenShots
Scenario: Handelling Screen Shots
Given I Navigate to Amazon url
Then I take the Amazon Home Page ScreenShot


@amazon @BrokenLinks
Scenario: Finding total no of Broken Links in a Web Page
Given I Navigate to Amazon url
Then I Find total Number of Broken Links present in a Web Page
