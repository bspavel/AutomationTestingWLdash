Meta:
@addNewCompany
Narrative:
As an admin or user
I want "create new company"
So that I can creat new company and see her in list company


Scenario: check the register company (short scenario)
Given go to Main page site
When as an user input data <username> and <password>
When go to Register Company page
When input data <customerID> and <parentID> and <companyName> and <dppersonId> and <notifEmail> and <emergencyEmail>
Then get success message
Examples:
|username|password|customerID|parentID|companyName|dppersonId|notifEmail|emergencyEmail|message|
|tester|qwertyuiop|testCustomerID|testParentID|testCompanyName|testDppersonId|testNotifEmail@com|testEmergencyEmail@com|SUCCESS SAVED DATA|
