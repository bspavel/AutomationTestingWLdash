Meta:
@loginPage

Narrative:
As an admin or user
I want login on site
So that I can login  and see button logout with role - admin,user

Scenario: check the login function as an admin
Given go to Main page site
When as an admin input data <username> and <password>
Then link Logout is displayed
Examples:
|username|password|
|pavel|qwertyuiop|

Scenario: check the login function as an user
Given go to Main page site
When as an user input data <username> and <password>
Then link Logout is displayed
Examples:
|username|password|
|tester|qwertyuiop|

Scenario: check validation login fields(negative)
Given go to Main page site
When as an admin input data <username> and <password>
Then get error message <expectedResult> near Username and Password fields
Examples:
|username|password|expectedResult|
|||Password cannot be blank.|
|123|query|Incorrect username or password.|

