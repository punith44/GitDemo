Feature: User Management Page Under Admin Page

@UserMngmt
@regression
Scenario: Add New Users to the Database
Given I Navigate to Orange HRM URL And Login to the Application
Then I Click on "Admin" Link on Main Page
When I Click on "Add" User button
Then I Enter following User details in Add User Page
  | ESS | murali krishna | RaviKK | Enabled | Ravi@123 |




@Naty
Scenario: Validate All the Nationalities Present in the Application
Given I Navigate to Orange HRM URL And Login to the Application
Then I Click on "Admin" Link on Main Page
Then I Click on Nationalities Link under Admin Section
Then I Validate the list of Nationalities in the page are as Expected





@homePageElements
Scenario: Validate All the web elements are present in Home Page
Given I Navigate to Orange HRM URL And Login to the Application
Then  I Validate All the following main Menu links are displayed
       | Admin | PIM | Leave | Time | Recruitment | My Info | Performance | Dashboard | Directory | Maintenance | Buzz |



@Naty @Scrollpage
Scenario: Validate All the Nationalities Present in the Application
Given I Navigate to Orange HRM URL And Login to the Application
Then I Click on "Admin" Link on Main Page
Then I Click on Nationalities Link under Admin Section
Then I Test the Scroll up and Scroll Down function
Then I Test Scroll to View Function on the Web Page