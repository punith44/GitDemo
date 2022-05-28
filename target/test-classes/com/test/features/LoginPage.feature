Feature: LoginPage

@LoginPage
@regression
Scenario: User Should Login into Application with Valid User Name and Valid Passwword
Given I Navigate to OrangeHRM URL
When I Enters Valid Username and Valid Password
Then I Clicks On Login Button
Then I Should be able to Login into Application

@InvCred
@regression
Scenario Outline: User Should not Login into Application with InValid UserName <UserName> and InValid Passwword <Password>
Given I Navigate to OrangeHRM URL
When I Enters InValid Username <UserName> and InValid Password <Password>
Then I Clicks On Login Button
Then I Should Not be able to Login into Application
Examples:
|   UserName    |   Password   |
|   Admin       |   pass       |
|   Admin123    |   admin123   |
|   Admin123    |    abc       |


@loginElements
@regression
Scenario: Verify all the respective Web Elements are displayed in Login Page
Given I Navigate to OrangeHRM URL
Then I validate whether all the Web Elements are displayed in Login Page

