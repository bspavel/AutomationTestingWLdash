Meta:
@checkLogIn

Narrative:
As an admin or user
I want login on site
So that I can login  and see button logout with role - admin,user

Scenario: check the login function as an admin
Given go to Main page site
When as an $role input login
Then link Logout is displayed
Examples:
|user|
|admin|
Scenario: check the login function as an user
Given go to Main page site
When as an $role input login
Then link Logout is displayed
Examples:
|user|
|user|

Scenario: check validation login fields(negative)
Given go to Main page site
When as an $role input login
Then get error message <expectedResult> near Username and Password fields
Examples:
|user|expectedResult|
|validation|Password cannot be blank.|


Scenario: check validation login fields(negative2)
Given go to Main page site
When as an $role input login
Then get error message <expectedResult> near Username and Password fields
Examples:
|user|expectedResult|
|validation2|Incorrect username or password.|