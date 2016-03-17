Meta:
@addNewCompany
Narrative:
As an admin or user
I want "create new company"
So that I can creat new company and see her in list company

Scenario: check the register company (short scenario)
Given go to Main page site
When as an user input login
When go to Register Company page
When input data <customerID> and <parentID> and <companyName> and <dppersonId> and <country> and <notifEmail> and <emergencyEmail>
Then get success message
Examples:
|customerID|parentID|companyName|dppersonId|notifEmail|country|emergencyEmail|message|
|testCustomerId|testParentID|testCompanyName|testDppersonId|ZZZ|testNotifEmail@yahoo.com|testEmergencyEmail@yahoo.
com|Data has been saved|