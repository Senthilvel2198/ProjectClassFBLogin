Feature: To check Facebook login page
Background:
Given Launch Chrome and Load Facebook login URL
Scenario: To check Login with invalid username and invalid password
When Enter invalid UsernamE
       |Senthil|Sojiya|Kia|Gypsy|
And Enter invalid PassworD
       |Senthil@123|Sojiya@123|
       |Kia@123|Gypsy@123|
And Click Login button
Then Popup incorrect credential page

Scenario Outline:
Feature: To Check Facebook Login Page
@PSG
Scenario: To Check Login with Valid User and Invalid Password
When Enter Valid User
          |UserName1|Messi|
          |UserName2|Neymar|
          |UserName3|Mbappe|
And Enter Invalid Pass
          |Pass1|Pass2|Pass3|
          |Messi@123|Neymar@123|Mbappe@123|
And Click login button
Then Popup incorrect password page

