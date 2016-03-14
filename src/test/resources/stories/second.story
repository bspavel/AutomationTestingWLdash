Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Meta: @skip
Scenario: check the register company (admin,user)
Given go to Main page site
When as an user input login
When input data <customerID> parentID, companyName, customerType, dppersonId
And input data firstName, lastName, country, address, state, zip, city
And input data phoneNumber, fax, email, notifEmail, emergencyEmail
Then link Logout is displayed
Examples:
|customerID|parentID|companyName|dppersonId|notifEmail|emergencyEmail|message|
|testCustomerID|testParentID|testCompanyName|testDppersonId|testNotifEmail@com|testEmergencyEmail@com|SUCCESS SAVED DATA|