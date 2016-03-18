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
When to enter data $typePage in fields
Then get success message
Examples:
|message|typePage|
|Data has been saved|vessel|
