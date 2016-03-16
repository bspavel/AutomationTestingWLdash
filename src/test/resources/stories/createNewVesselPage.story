Meta:
@addNewVessel
Narrative:
As an admin or user
I want "create new vessel"
So that I can creat new vessel and see her in list vessel

Scenario: check the register vessel (short scenario)
Given go to Main page site
When as an user input login
When go to Register Vessel page
When input data in the fields like: <customerID> and <parentID> and <companyName> and <dppersonId> and <notifEmail> and <emergencyEmail>
Then get success message
Examples:
|customerID|parentID|companyName|dppersonId|notifEmail|emergencyEmail|message|
|Oleksandr|Irina|testCompanyName|testDppersonId|testNotifEmail@yahoo.com|testEmergencyEmail@yahoo.com|Data has been saved|
